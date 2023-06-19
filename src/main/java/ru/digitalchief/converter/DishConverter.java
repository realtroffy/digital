package ru.digitalchief.converter;

import org.mapstruct.Mapper;
import ru.digitalchief.dto.DishDto;
import ru.digitalchief.model.Dish;

@Mapper(componentModel = "spring")
public interface DishConverter {

    Dish toEntity(DishDto dishDto);

    DishDto toDto(Dish dish);
}