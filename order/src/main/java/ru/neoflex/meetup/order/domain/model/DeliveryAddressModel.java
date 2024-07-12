package ru.neoflex.meetup.order.domain.model;

import lombok.Getter;

@Getter
public class DeliveryAddressModel {
    private String street;
    private String city;
    private String country;
}
