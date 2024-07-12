package ru.neoflex.meetup.restaurant.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivannikov.meetup.utils.enumeration.CommandTypeEnum;
import ru.ivannikov.meetup.utils.enumeration.EventAggregateIdEnum;
import ru.ivannikov.meetup.utils.enumeration.EventAggregateTypeEnum;
import ru.ivannikov.meetup.utils.model.HeadersModel;
import ru.neoflex.meetup.restaurant.domain.dto.CreateRestaurantRequestDto;
import ru.neoflex.meetup.restaurant.domain.dto.CreateRestaurantResponseDto;
import ru.neoflex.meetup.restaurant.domain.entity.OutboxEntity;
import ru.neoflex.meetup.restaurant.domain.entity.RestaurantEntity;
import ru.neoflex.meetup.restaurant.domain.payload.RestaurantPayload;
import ru.neoflex.meetup.restaurant.repository.OutboxRepository;
import ru.neoflex.meetup.restaurant.repository.RestaurantRepository;
import ru.neoflex.meetup.restaurant.service.RestaurantService;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final OutboxRepository outboxRepository;

    @Value("${kafka.topics.restaurantEventsTopic}")
    private String restaurantEventsTopic;

    @Override
    @Transactional
    public CreateRestaurantResponseDto createRestaurant(CreateRestaurantRequestDto createRestaurantRequestDto) {
//         здесь можно сделать по шаблону доменные события
        RestaurantEntity restaurantEntity = new RestaurantEntity();
        restaurantEntity.setName(createRestaurantRequestDto.getName());
        restaurantEntity.setAddress(createRestaurantRequestDto.getAddress());
        restaurantRepository.save(restaurantEntity);

        RestaurantPayload restaurantPayload = new RestaurantPayload();
        restaurantPayload.setName(createRestaurantRequestDto.getName());
        restaurantPayload.setAddress(createRestaurantRequestDto.getAddress());

        HeadersModel headers = new HeadersModel(
                restaurantEntity.getId(),
                EventAggregateTypeEnum.RESTAURANT,
                EventAggregateIdEnum.RESTAURANT_CREATED,
                CommandTypeEnum.CREATE_RESTAURANT,
                new Date().getTime()
        );
        OutboxEntity outboxEntity = new OutboxEntity(
                restaurantEventsTopic,
                new Date().getTime(),
                restaurantPayload,
                headers
        );
        outboxRepository.save(outboxEntity);
        return new CreateRestaurantResponseDto()
    }
}
