package ru.neoflex.meetup.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.meetup.restaurant.domain.entity.OutboxEntity;

public interface OutboxRepository extends JpaRepository<OutboxEntity, Long> {
}
