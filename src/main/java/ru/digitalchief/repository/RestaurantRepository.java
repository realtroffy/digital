package ru.digitalchief.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.digitalchief.model.Restaurant;

public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, Long> {}
