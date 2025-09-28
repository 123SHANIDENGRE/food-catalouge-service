package com.codedecode.foodcatalouge.dto;

import java.util.Objects;


public class FoodItemDTO {


    private int id;
    private String itemName;
    private String itemDescription;
    public boolean veg;
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

    public boolean isVeg() {
        return veg;
    }

    public void setVeg(boolean veg) {
        this.veg = veg;
    }

    public FoodItemDTO(int id, String itemName, String itemDescription, boolean veg, Long price, Integer restaurantId, Integer quantity) {
        this.id = id;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.veg = veg;
        this.price = price;
        this.restaurantId = restaurantId;
        this.quantity = quantity;
    }


    public FoodItemDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FoodItemDTO that)) return false;
        return id == that.id && veg == that.veg && Objects.equals(itemName, that.itemName) && Objects.equals(itemDescription, that.itemDescription) && Objects.equals(price, that.price) && Objects.equals(restaurantId, that.restaurantId) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemName, itemDescription, veg, price, restaurantId, quantity);
    }
}
