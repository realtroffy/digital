package ru.digitalchief.dto;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class DishDto {

    private Long id;

    @Size(min = 5, max = 50, message = "Name length should be between 5 and 50 characters")
    private String name;

    @Size(min = 5, max = 100, message = "Description length should be between 5 and 100 characters")
    private String description;

    @NotNull
    @DecimalMin(value = "0", inclusive = false, message = "Must be greater than 0")
    private BigDecimal price;

    @NotNull(message = "Must specify vegetarian or not")
    private boolean isVegetarian;

    @NotNull(message = "Must specify has dietary restriction or not")
    private boolean isDietaryRestriction;
}
