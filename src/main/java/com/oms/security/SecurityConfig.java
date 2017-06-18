package com.oms.security;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.oms.entity.Role;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public static final ArrayList<String> roles = new ArrayList<String>();

	static{
		roles.add("ROLE_FREE_USER");
		roles.add("ROLE_PAID_USER");
	}

	@Autowired
	private DataSource dataSource;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder registry) throws Exception {


		registry.userDetailsService(customUserDetailsService);
	}
	@Override
	public void configure(WebSecurity web) throws Exception {

	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/Home/**").permitAll()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
		.and().formLogin();

	}
}