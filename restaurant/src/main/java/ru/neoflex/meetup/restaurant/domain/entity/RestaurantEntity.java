package ru.neoflex.meetup.restaurant.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.neoflex.meetup.restaurant.domain.model.AddressModel;

import java.util.List;
import java.util.UUID;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@Table(name = "restaurant")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @Embedded
    private AddressModel address;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<MenuItemEntity> menuItems;
}
