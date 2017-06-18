package com.oms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.oms.entity.User;
import com.oms.service.AdminService;

@Component
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private AdminService userService;
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		System.out.println("before");
		User user = userService.findUserByEmail(userName);
		System.out.println(user.getEmail()+user.getPassword());
		if(user == null){

			throw new UsernameNotFoundException("UserName "+userName+" not found");
		}
		return new SecurityUser(user);
	}
}