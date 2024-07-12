package ru.neoflex.meetup.restaurant.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ru.ivannikov.meetup.utils.model.HeadersModel;
import ru.neoflex.meetup.restaurant.domain.payload.RestaurantPayload;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "outbox")
public class OutboxEntity {

    public OutboxEntity(String topic, Long creationTime, RestaurantPayload payload, HeadersModel headers) {
        this.topic = topic;
        this.creationTime = creationTime;
        this.payload = payload;
        this.headers = headers;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String topic;

    private Boolean published = false;

    @Column(name = "creation_time")
    private Long creationTime;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private RestaurantPayload payload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private HeadersModel headers;

//    private Integer messagePartition
}