package com.hcl.foodorder.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hcl.foodorder.security.domain.User;
import com.hcl.foodorder.security.repository.UserRepository;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if (user == null)
			throw new UsernameNotFoundException("User Not Found For Email " + username);
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				user.getRoles());
	}

}
