package ru.neoflex.meetup.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.meetup.order.domain.dto.CreateOrderRequestDto;
import ru.neoflex.meetup.order.domain.dto.CreateOrderResponseDto;
import ru.neoflex.meetup.order.service.OrderService;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<CreateOrderResponseDto> create(@RequestBody CreateOrderRequestDto createOrderRequestDto) {
        CreateOrderResponseDto createOrderResponseDto = orderService.createOrder(createOrderRequestDto);
        return new ResponseEntity<>(createOrderResponseDto, HttpStatus.CREATED);
    }
}
