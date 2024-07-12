package ru.neoflex.meetup.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.meetup.restaurant.domain.dto.CreateRestaurantRequestDto;
import ru.neoflex.meetup.restaurant.domain.dto.CreateRestaurantResponseDto;
import ru.neoflex.meetup.restaurant.service.RestaurantService;

@RestController
@RequiredArgsConstructor
@RequestMapping("restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<CreateRestaurantResponseDto> create(@RequestBody CreateRestaurantRequestDto createRestaurantRequestDto) {
        restaurantService.createRestaurant(createRestaurantRequestDto);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
