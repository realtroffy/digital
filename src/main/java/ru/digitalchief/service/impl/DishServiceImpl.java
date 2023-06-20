package ru.digitalchief.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.digitalchief.converter.DishConverter;
import ru.digitalchief.dto.DishDto;
import ru.digitalchief.model.Dish;
import ru.digitalchief.repository.DishRepository;
import ru.digitalchief.service.DishService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
@Service
@AllArgsConstructor
public class DishServiceImpl implements DishService {

    private static final String NO_SUCH_DISH_EXCEPTION_MESSAGE =
            "Dish was not found by id = ";
    private final DishRepository dishRepository;
    private final DishConverter dishConverter;
    @Override
    @Transactional(readOnly = true)
    public DishDto getById(long id) {
        Dish dish =
                dishRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new NoSuchElementException(NO_SUCH_DISH_EXCEPTION_MESSAGE + id));
        return dishConverter.toDto(dish);
    }

    @Override
    @Transactional
    public DishDto save(DishDto dishDto) {
        Dish dish = dishRepository.save(dishConverter.toEntity(dishDto));
        dishDto.setId(dish.getId());
        return dishDto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DishDto> getAll() {
        List<DishDto> dishes = new ArrayList<>();
        dishRepository
                .findAll()
                .forEach(
                        dish -> dishes.add(dishConverter.toDto(dish)));
        return dishes;
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        dishRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(long id, DishDto forUpdate) {
        DishDto old = getById(id);
        dishRepository.save(dishConverter.toEntity(old));
    }
}