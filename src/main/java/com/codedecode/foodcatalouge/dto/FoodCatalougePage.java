package com.codedecode.foodcatalouge.dto;

import com.codedecode.foodcatalouge.entity.FoodItem;


import java.util.List;
import java.util.Objects;


public class FoodCatalougePage {

    private List<FoodItem> foodItemList;
    private Restaurant restaurant;

    public List<FoodItem> getFoodItemList() {
        return foodItemList;
    }

    public void setFoodItemList(List<FoodItem> foodItemList) {
        this.foodItemList = foodItemList;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FoodCatalougePage that)) return false;
        return Objects.equals(foodItemList, that.foodItemList) && Objects.equals(restaurant, that.restaurant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodItemList, restaurant);
    }

    public FoodCatalougePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        this.foodItemList = foodItemList;
        this.restaurant = restaurant;
    }

    public FoodCatalougePage() {
    }
}
