package ru.neoflex.meetup.order.service;

import ru.neoflex.meetup.order.domain.dto.CreateOrderRequestDto;
import ru.neoflex.meetup.order.domain.dto.CreateOrderResponseDto;

public interface OrderService {

    CreateOrderResponseDto createOrder(CreateOrderRequestDto createOrderRequestDto);
}
