package ru.neoflex.meetup.order.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import ru.neoflex.meetup.order.domain.model.DeliveryAddressModel;
import ru.neoflex.meetup.order.domain.model.OrderLineItemModel;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
// JonInclude.NON_NULL
public class CreateOrderRequestDto {

    @JsonProperty(value = "restaurant_id")
    private long restaurantId;

    @JsonProperty(value = "consumer_id")
    private long consumerId;

    @JsonProperty(value = "delivery_time")
    private LocalDateTime deliveryTime;

    @JsonProperty(value = "line_items")
    private List<OrderLineItemModel> orderLineItems;

    @JsonProperty(value = "delivery_address")
    private DeliveryAddressModel deliveryAddress;
}
