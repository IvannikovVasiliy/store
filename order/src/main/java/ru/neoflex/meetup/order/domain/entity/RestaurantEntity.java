package ru.neoflex.meetup.order.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table("restaurant_read_only")
public class RestaurantEntity {

    @Id
    @GeneratedValue
}
