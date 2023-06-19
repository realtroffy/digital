package ru.digitalchief.converter;

import org.mapstruct.Mapper;
import ru.digitalchief.dto.RestaurantDto;
import ru.digitalchief.model.Restaurant;

@Mapper(componentModel = "spring")
public interface RestaurantConverter {

    Restaurant toEntity(RestaurantDto restaurantDto);

    RestaurantDto toDto(Restaurant restaurant);
}
