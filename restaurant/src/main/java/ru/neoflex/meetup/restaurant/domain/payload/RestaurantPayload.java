package ru.neoflex.meetup.restaurant.domain.payload;

import jakarta.persistence.Embedded;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.neoflex.meetup.restaurant.domain.model.AddressModel;

@Getter
@Setter
@EqualsAndHashCode
public class RestaurantPayload {
    private String name;
    private AddressModel address;
}