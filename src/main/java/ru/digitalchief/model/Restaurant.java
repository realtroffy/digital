package ru.digitalchief.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 4726410569172878074L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_generator")
    @SequenceGenerator(
            name = "restaurant_generator",
            sequenceName = "restaurant_sequence",
            allocationSize = 3)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private Cuisine cuisine;

    @Column
    private String location;

    @Column
    private Integer capacity;

    @Column
    private Double stars;

    @ToString.Exclude
    @OneToMany(fetch = EAGER, mappedBy = "restaurant", cascade = ALL, orphanRemoval = true)
    private List<Dish> dishes = new ArrayList<>();

    public void addDishToRestaurant(Dish dish) {
        dishes.add(dish);
        dish.setRestaurant(this);
    }

    public void deleteDishFromRestaurant(Dish dish){
        dishes.remove(dish);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(name, that.name)
                && cuisine == that.cuisine
                && Objects.equals(location, that.location)
                && Objects.equals(capacity, that.capacity)
                && Objects.equals(stars, that.stars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cuisine, location, capacity, stars);
    }
}
