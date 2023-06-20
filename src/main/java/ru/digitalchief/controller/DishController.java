package ru.digitalchief.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.digitalchief.dto.DishDto;
import ru.digitalchief.service.DishService;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/api/dishes")
public class DishController {

  private final DishService dishService;

  @GetMapping("/{id}")
  public ResponseEntity<DishDto> getById(@PathVariable("id") long id) {
    return ResponseEntity.ok(dishService.getById(id));
  }

  @GetMapping
  public ResponseEntity<List<DishDto>> getAll() {
    List<DishDto> restaurants = dishService.getAll();
    return ResponseEntity.ok(restaurants);
  }

  @PostMapping
  public ResponseEntity<DishDto> save(@RequestBody @Valid DishDto dishDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(dishService.save(dishDto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(
      @PathVariable("id") long id, @Valid @RequestBody DishDto dishDto) {
    dishService.update(id, dishDto);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") long id) {
    dishService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
