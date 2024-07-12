package ru.neoflex.meetup.restaurant.service;

import ru.neoflex.meetup.restaurant.domain.dto.CreateRestaurantRequestDto;
import ru.neoflex.meetup.restaurant.domain.dto.CreateRestaurantResponseDto;

public interface RestaurantService {
    CreateRestaurantResponseDto createRestaurant(CreateRestaurantRequestDto createRestaurantRequestDto);
}
