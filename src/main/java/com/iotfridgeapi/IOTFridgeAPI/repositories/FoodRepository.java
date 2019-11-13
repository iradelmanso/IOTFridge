package com.iotfridgeapi.IOTFridgeAPI.repositories;

import com.iotfridgeapi.IOTFridgeAPI.models.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Integer> {

}
