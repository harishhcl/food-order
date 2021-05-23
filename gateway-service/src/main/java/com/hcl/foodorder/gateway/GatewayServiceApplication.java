package com.hcl.foodorder.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.codec.ServerCodecConfigurer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@ComponentScan("com.hcl.foodorder.security.*")
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
	/*
	 * @Bean public ServerCodecConfigurer serverCodecConfigurer() { return
	 * ServerCodecConfigurer.create(); }
	 */
}
