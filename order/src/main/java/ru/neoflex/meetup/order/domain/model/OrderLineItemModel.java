package ru.neoflex.meetup.order.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OrderLineItemModel {

    @JsonProperty(value = "menu_item_id")
    private Long menuItemId;

    private Integer quantity;
}
