package ru.neoflex.meetup.order.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "order_line_items")
public class OrderLineItemEntity {

    public OrderLineItemEntity(Integer quantity, Long menuItemId, OrderEntity order) {
        this.quantity = quantity;
        this.menuItemId = menuItemId;
        this.order = order;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    // говнокод
    @Column(name = "menu_item_id")
    private Long menuItemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
    // Column или JoinColumn
    // not null
}
