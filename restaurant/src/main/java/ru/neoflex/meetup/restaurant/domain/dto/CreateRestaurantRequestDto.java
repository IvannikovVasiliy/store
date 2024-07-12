package ru.neoflex.meetup.restaurant.domain.dto;

import lombok.Getter;
import lombok.Setter;
import ru.neoflex.meetup.restaurant.domain.model.AddressModel;

@Getter
@Setter
public class CreateRestaurantRequestDto {
    private String name;
    private AddressModel address;
}
