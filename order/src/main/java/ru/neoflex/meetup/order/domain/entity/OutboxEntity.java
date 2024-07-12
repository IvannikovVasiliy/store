package ru.neoflex.meetup.order.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "outbox")
public class OutboxEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String destination;

//    private boolean published;

    @Column(name = "creation_time")
    private Long creationTime;

    @JdbcTypeCode(SqlTypes.JSON)
    private Object payload;

    @JdbcTypeCode(SqlTypes.JSON)
    private Object headers;

//    private Integer messagePartition
}
