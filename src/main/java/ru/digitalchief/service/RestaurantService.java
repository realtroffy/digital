package ru.digitalchief.service;

import ru.digitalchief.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {

    RestaurantDto getById(long id);

    RestaurantDto save(RestaurantDto restaurantDto);

    List<RestaurantDto> getAll();

    void deleteById(long id);

    void update(long id, RestaurantDto forUpdate);

    void addDishToRestaurant(long restaurantId, long dishId);

    void deleteDishFromRestaurant(long restaurantId, long dishId);
}
