package ru.neoflex.meetup.restaurant.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class CreateRestaurantResponseDto {
    private UUID id;
}
