package ru.neoflex.meetup.restaurant.domain.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
public class AddressModel {
    private String street;
    private String city;
    private String country;
}
