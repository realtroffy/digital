package ru.digitalchief.service;

import ru.digitalchief.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {

    RestaurantDto getById(long id);

    RestaurantDto save(RestaurantDto eventDto);

    List<RestaurantDto> getAll();

    void deleteById(long id);

    void update(long id, RestaurantDto eventDto);

    void addDishToRestaurant(long dishId, long restaurantId);
}
