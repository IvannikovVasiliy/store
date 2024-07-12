package ru.neoflex.meetup.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.meetup.order.domain.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
