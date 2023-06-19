package ru.digitalchief.validator.cuisine;

import ru.digitalchief.model.Cuisine;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CuisineValidator implements ConstraintValidator<ValidCuisine, Cuisine> {

  @Override
  public boolean isValid(Cuisine value, ConstraintValidatorContext context) {
    if (value == null) {
      return false;
    }

    switch (value) {
      case EASTERN:
      case ITALIAN:
      case FRENCH:
      case MEXICAN:
        return true;
      default:
        return false;
    }
  }
}
