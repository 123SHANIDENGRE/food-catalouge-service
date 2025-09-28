package com.codedecode.foodcatalouge.controller;

import com.codedecode.foodcatalouge.dto.FoodCatalougePage;
import com.codedecode.foodcatalouge.dto.FoodItemDTO;
import com.codedecode.foodcatalouge.service.FoodCatalougeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FoodCatalougeControllerTest {


    @Mock
    FoodCatalougeService foodCatalougeService;

    @InjectMocks
    FoodCatalougeController  foodCatalougeController;

    @BeforeEach
    public void setUp() {
        AutoCloseable autoCloseable = MockitoAnnotations.openMocks(this);//in order for Mock and InjectMocks annotations to take effect, you need to call MockitoAnnotations.openMocks(this);
    }


    @Test
    public void  addFoodItem()
    {
        FoodItemDTO  mockFooditem=new FoodItemDTO();

        when(foodCatalougeService.addFoodItem(any(FoodItemDTO.class))).thenReturn(mockFooditem);
        // Act
        ResponseEntity<FoodItemDTO> response = foodCatalougeController.addFoodItem(mockFooditem);
        // Assert
        verify(foodCatalougeService, times(1)).addFoodItem(mockFooditem);
        assert response.getStatusCode() == HttpStatus.CREATED;
        assert response.getBody() == mockFooditem;
    }


    @Test
    void fetchRestauDetailsWithFoodMenu_ShouldReturnOkStatus() {
        // Arrange
        int restaurantId = 123;
        FoodCatalougePage foodCataloguePage = new FoodCatalougePage();
        when(foodCatalougeService.fetchFoodCataloguePageDetails(restaurantId)).thenReturn(foodCataloguePage);

        // Act
        ResponseEntity<FoodCatalougePage> response = foodCatalougeController.fetchRestauDetailsWithFoodMenu(restaurantId);

        // Assert
        verify(foodCatalougeService, times(1)).fetchFoodCataloguePageDetails(restaurantId);
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == foodCataloguePage;
    }



}
