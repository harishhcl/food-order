package com.hcl.foodorder.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 
 * @author Harishkumar Reddy
 *
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
//@EnableEurekaClient
@EnableMongoRepositories
public class RestaurantServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantServiceApplication.class, args);
	}

}
