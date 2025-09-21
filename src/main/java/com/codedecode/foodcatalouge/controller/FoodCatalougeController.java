package com.codedecode.foodcatalouge.controller;


import com.codedecode.foodcatalouge.dto.FoodCatalougePage;
import com.codedecode.foodcatalouge.dto.FoodItemDTO;
import com.codedecode.foodcatalouge.service.FoodCatalougeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalouge")
@CrossOrigin
public class FoodCatalougeController {

    @Autowired
    private FoodCatalougeService foodCatalougeService;


    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDTO>  addFoodItem(@RequestBody FoodItemDTO foodItemDTO)
    {
        FoodItemDTO foodItemDTOSaved= foodCatalougeService.addFoodItem(foodItemDTO);
        return  new ResponseEntity<>(foodItemDTOSaved, HttpStatus.CREATED);
    }


    @GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
    public ResponseEntity<FoodCatalougePage> fetchRestauDetailsWithFoodMenu(@PathVariable Integer restaurantId){
        FoodCatalougePage foodCataloguePage = foodCatalougeService.fetchFoodCataloguePageDetails(restaurantId);
        return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);


    }
}
