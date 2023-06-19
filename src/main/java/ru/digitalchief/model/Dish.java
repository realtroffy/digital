package ru.digitalchief.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dish implements Serializable {

  private static final long serialVersionUID = -2156626744976317146L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dish_generator")
  @SequenceGenerator(
      name = "dish_generator",
      sequenceName = "dish_sequence",
      allocationSize = 3)
  @Column
  private Long id;

  @Column private String name;

  @Column private String description;

  @Column private BigDecimal price;

  @Column private boolean isVegetarian;

  @Column private boolean isDietaryRestriction;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn
  private Restaurant restaurant;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Dish dish = (Dish) o;
    return isVegetarian == dish.isVegetarian
        && isDietaryRestriction == dish.isDietaryRestriction
        && Objects.equals(name, dish.name)
        && Objects.equals(description, dish.description)
        && Objects.equals(price, dish.price)
        && Objects.equals(restaurant, dish.restaurant);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, price, isVegetarian, isDietaryRestriction, restaurant);
  }

  @Override
  public String toString() {
    return "Dish{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", description='"
        + description
        + '\''
        + ", price="
        + price
        + ", isVegetarian="
        + isVegetarian
        + ", isDietaryRestriction="
        + isDietaryRestriction
        + ", restaurant="
        + restaurant
        + '}';
  }
}
