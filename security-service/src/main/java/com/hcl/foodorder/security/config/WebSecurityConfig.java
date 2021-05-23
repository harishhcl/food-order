package com.hcl.foodorder.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hcl.foodorder.security.service.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("***************** AuthenticationManagerBuilder ");
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("***************** HttpSecurity ");
		http.httpBasic();
		http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/orders/v1/get/**").hasAnyRole("RESTAURANT", "CUSTOMER")
				.mvcMatchers(HttpMethod.GET, "/restaurants/v1/get/**").hasAnyRole("USER", "ADMIN")
				.mvcMatchers("/restaurants/v1/create").hasRole("ADMIN").and().csrf().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}
}
