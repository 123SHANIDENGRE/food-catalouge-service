package com.codedecode.foodcatalouge.mapper;

import com.codedecode.foodcatalouge.dto.FoodItemDTO;
import com.codedecode.foodcatalouge.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface FoodItemMapper {

    FoodItemMapper INSTANCE= Mappers.getMapper(FoodItemMapper.class);

     FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);
    FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);

}

