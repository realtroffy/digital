package ru.digitalchief.dto;

import lombok.Data;
import ru.digitalchief.model.Cuisine;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
public class RestaurantDto {

  private Long id;

  @Size(min = 5, max = 50, message = "Name length should be between 5 and 50 characters")
  private String name;

  private Cuisine cuisine;

  @Size(min = 5, max = 50, message = "Location length should be between 5 and 50 characters")
  private String location;

  @Positive(message = "Capacity must be positive")
  private Integer capacity;

  @Min(value = 0, message = "Value must be between 0 to 3")
  @Max(value = 3, message = "Value must be between 0 to 3")
  private Byte star;
}
