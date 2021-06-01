package com.hcl.foodorder.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
/**
 * 
 * @author Harishkumar Reddy
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@EnableEurekaClient
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
