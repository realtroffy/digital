package ru.digitalchief.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.digitalchief.dto.DishDto;
import ru.digitalchief.model.Dish;

@Mapper(componentModel = "spring")
public interface DishConverter {


  Dish toEntity(DishDto dishDto);

  @Mapping(target = "restaurantId", expression = "java(dish.getRestaurant().getId())")
  DishDto toDto(Dish dish);
}
