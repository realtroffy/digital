package ru.digitalchief.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.digitalchief.dto.RestaurantDto;
import ru.digitalchief.service.RestaurantService;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/api/restaurants")
public class RestaurantController {

  private final RestaurantService restaurantService;

  @GetMapping("/{id}")
  public ResponseEntity<RestaurantDto> getById(@PathVariable("id") long id) {
    return ResponseEntity.ok(restaurantService.getById(id));
  }

  @GetMapping
  public ResponseEntity<List<RestaurantDto>> getAll() {
    List<RestaurantDto> restaurants = restaurantService.getAll();
    return ResponseEntity.ok(restaurants);
  }

  @PostMapping()
  public ResponseEntity<RestaurantDto> save(@RequestBody @Valid RestaurantDto restaurantDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.save(restaurantDto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(
      @PathVariable("id") long id, @Valid @RequestBody RestaurantDto restaurantDto) {
    restaurantService.update(id, restaurantDto);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") long id) {
    restaurantService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
