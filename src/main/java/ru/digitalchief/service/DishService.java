package ru.digitalchief.service;

import ru.digitalchief.dto.DishDto;
import ru.digitalchief.dto.RestaurantDto;

import java.util.List;

public interface DishService {

    DishDto getById(long id);

    DishDto save(DishDto dishDto);

    List<DishDto> getAll();

    void deleteById(long id);

    void update(long id, DishDto dishDto);
}
