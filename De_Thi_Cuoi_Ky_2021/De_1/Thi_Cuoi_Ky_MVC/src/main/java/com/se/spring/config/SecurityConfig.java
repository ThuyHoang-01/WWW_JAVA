package com.se.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// Configure Authentication voi cac account mac dinh
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(users.username("john").password("test123").roles("EMPLOYEE"))
				.withUser(users.username("mary").password("test123").roles("MANAGER"))
				.withUser(users.username("susan").password("test123").roles("ADMIN"));
	}

	// Configure cac trang xu ly voi Authentication
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// ** matches zero or more 'directories' in a path
		http.authorizeRequests()
				// * matches zero or more characters
				.antMatchers("/resources/css/**").permitAll().antMatchers("/resources/bootstrap/**").permitAll()
				.antMatchers("/resources/jquery/**").permitAll().antMatchers("/resources/fonts/**").permitAll()

				/*
				 * .antMatchers("/lop/**").hasRole("EMPLOYEE")
				 * .antMatchers("/lop/showForm*").hasAnyRole("MANAGER", "ADMIN")
				 * .antMatchers("/lop/save*").hasAnyRole("MANAGER", "ADMIN")
				 * .antMatchers("/lop/delete").hasRole("ADMIN")
				 * .antMatchers("/sinhvien/**").hasRole("EMPLOYEE")
				 * .antMatchers("/sinhvien/showForm*").hasAnyRole("MANAGER", "ADMIN")
				 * .antMatchers("/sinhvien/save*").hasAnyRole("MANAGER", "ADMIN")
				 */

				.antMatchers("/sinhvien/delete").hasRole("ADMIN")

				// ** matches zero or more 'directories' in a path
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/").permitAll().and().formLogin()
				.loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").defaultSuccessUrl("/home").permitAll()
				.and()
				.logout().permitAll()
				.and().exceptionHandling().accessDeniedPage("/access-denied");
	}
}
