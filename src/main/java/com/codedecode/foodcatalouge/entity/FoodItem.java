package com.codedecode.foodcatalouge.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


@Entity
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String itemName;
   private String itemDescription;
   private boolean veg;
   private Long price;
   private Integer restaurantId;
   private Integer quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public boolean isVeg() {
        return veg;
    }

    public void setVeg(boolean veg) {
        this.veg = veg;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FoodItem foodItem)) return false;
        return id == foodItem.id && veg == foodItem.veg && Objects.equals(itemName, foodItem.itemName) && Objects.equals(itemDescription, foodItem.itemDescription) && Objects.equals(price, foodItem.price) && Objects.equals(restaurantId, foodItem.restaurantId) && Objects.equals(quantity, foodItem.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemName, itemDescription, veg, price, restaurantId, quantity);
    }




}
