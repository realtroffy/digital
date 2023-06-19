package ru.digitalchief.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.digitalchief.model.Dish;

public interface DishRepository extends PagingAndSortingRepository<Dish, Long> {}
