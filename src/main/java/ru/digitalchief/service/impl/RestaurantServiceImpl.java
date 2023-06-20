package ru.digitalchief.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.digitalchief.converter.RestaurantConverter;
import ru.digitalchief.dto.RestaurantDto;
import ru.digitalchief.model.Restaurant;
import ru.digitalchief.repository.RestaurantRepository;
import ru.digitalchief.service.RestaurantService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

  private static final String NO_SUCH_RESTAURANT_EXCEPTION_MESSAGE =
      "Restaurant was not found by id = ";
  private final RestaurantRepository restaurantRepository;
  private final RestaurantConverter restaurantConverter;

  @Override
  @Transactional(readOnly = true)
  public RestaurantDto getById(long id) {
    Restaurant restaurant =
        restaurantRepository
            .findById(id)
            .orElseThrow(
                () -> new NoSuchElementException(NO_SUCH_RESTAURANT_EXCEPTION_MESSAGE + id));
    return restaurantConverter.toDto(restaurant);
  }

  @Override
  @Transactional
  public RestaurantDto save(RestaurantDto restaurantDto) {
    Restaurant restaurant = restaurantRepository.save(restaurantConverter.toEntity(restaurantDto));
    restaurantDto.setId(restaurant.getId());
    return restaurantDto;
  }

  @Override
  @Transactional(readOnly = true)
  public List<RestaurantDto> getAll() {
    List<RestaurantDto> restaurants = new ArrayList<>();
    restaurantRepository
        .findAll()
        .forEach(restaurant -> restaurants.add(restaurantConverter.toDto(restaurant)));
    return restaurants;
  }

  @Override
  @Transactional
  public void deleteById(long id) {
    restaurantRepository.deleteById(id);
  }

  @Override
  @Transactional
  public void update(long id, RestaurantDto forUpdate) {
    getById(id);
    forUpdate.setId(id);
    Restaurant restaurant = restaurantConverter.toEntity(forUpdate);
    restaurantRepository.save(restaurant);
  }
}
