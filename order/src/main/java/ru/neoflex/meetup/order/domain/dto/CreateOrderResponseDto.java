package ru.neoflex.meetup.order.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateOrderResponseDto {

    @JsonProperty(value = "order_id")
    private long orderId;
}
