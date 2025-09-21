package com.codedecode.foodcatalouge.service;


import com.codedecode.foodcatalouge.dto.FoodCatalougePage;
import com.codedecode.foodcatalouge.dto.FoodItemDTO;
import com.codedecode.foodcatalouge.dto.Restaurant;
import com.codedecode.foodcatalouge.entity.FoodItem;
import com.codedecode.foodcatalouge.mapper.FoodItemMapper;
import com.codedecode.foodcatalouge.repository.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalougeService {

    @Autowired
    private FoodItemRepo foodItemRepo;

    @Autowired
    RestTemplate restTemplate;


    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {

        FoodItem  FoodItemSaved=foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(FoodItemSaved);
    }

    public FoodCatalougePage fetchFoodCataloguePageDetails(Integer restaurantId) {

   List<FoodItem> foodItemList=fetchFoodItemList(restaurantId);
   Restaurant restaurant= fetchRestaurantDetailsFromRestaurantMS(restaurantId);
  return  createFoodCatalougePage(foodItemList,restaurant);

    }

    private FoodCatalougePage createFoodCatalougePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCatalougePage foodCataloguePage = new FoodCatalougePage();
        foodCataloguePage.setFoodItemList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
        return   restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId, Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {

        return foodItemRepo.findByRestaurantId(restaurantId);
    }
}
