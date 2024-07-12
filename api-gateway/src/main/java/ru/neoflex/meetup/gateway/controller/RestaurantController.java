package ru.neoflex.meetup.gateway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.meetup.gateway.dto.CreateRestaurantRequestDto;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping("restaurant")
public class RestaurantController {

    @PostMapping
    public CompletableFuture<Void> create(@RequestBody CreateRestaurantRequestDto createRestaurantRequestDto) {

        return null;
    }
}
