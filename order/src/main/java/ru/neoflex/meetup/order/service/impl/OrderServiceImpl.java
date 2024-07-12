package ru.neoflex.meetup.order.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neoflex.meetup.order.domain.dto.CreateOrderRequestDto;
import ru.neoflex.meetup.order.domain.dto.CreateOrderResponseDto;
import ru.neoflex.meetup.order.domain.embedded.DeliveryAddressEmbedded;
import ru.neoflex.meetup.order.domain.entity.OrderEntity;
import ru.neoflex.meetup.order.domain.entity.OrderLineItemEntity;
import ru.neoflex.meetup.order.repository.OrderRepository;
import ru.neoflex.meetup.order.domain.enumeration.OrderStatus;
import ru.neoflex.meetup.order.service.OrderService;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    // возможно написать через домен
    @Override
    @Transactional
    public CreateOrderResponseDto createOrder(CreateOrderRequestDto createOrderRequestDto) {
        OrderEntity order = new OrderEntity();
        // hardCode
        order.setAmount(new BigDecimal("1.0"));
        order.setOrderStatus(OrderStatus.APPROVAL_PENDING);
        order.setDeliveryAddress(new DeliveryAddressEmbedded(
                createOrderRequestDto.getDeliveryAddress().getStreet(),
                createOrderRequestDto.getDeliveryAddress().getCity(),
                createOrderRequestDto.getDeliveryAddress().getCountry()
        ));
        List<OrderLineItemEntity> orderLineItems = createOrderRequestDto
                .getOrderLineItems()
                .stream()
                .map(orderLineItem -> new OrderLineItemEntity(orderLineItem.getQuantity(), orderLineItem.getMenuItemId(), order))
                .toList();
        order.setOrderLineItems(orderLineItems);
        orderRepository.save(order);
        return new CreateOrderResponseDto(order.getId());
    }
}
