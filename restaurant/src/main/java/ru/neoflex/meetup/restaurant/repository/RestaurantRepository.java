package ru.neoflex.meetup.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.meetup.restaurant.domain.entity.RestaurantEntity;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
}
