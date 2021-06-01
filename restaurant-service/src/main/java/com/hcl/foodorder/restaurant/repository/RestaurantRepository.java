package com.hcl.foodorder.restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hcl.foodorder.domain.restaurant.Restaurant;
/**
 * 
 * @author Harishkumar Reddy
 *
 */
@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, Long>{

}
