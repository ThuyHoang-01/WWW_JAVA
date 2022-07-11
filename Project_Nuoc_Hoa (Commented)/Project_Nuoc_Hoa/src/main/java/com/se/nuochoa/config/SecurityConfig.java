package com.se.nuochoa.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// Tạo reference đến security data source
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Sử dụng jdbcAuthentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// ** Cài đặt cấu hình match phù hợp từ 0 đến nhiều 'directories' trong một path
		http.authorizeRequests()
				// * match với 0 hoặc nhiều thành phần
				.antMatchers("/resources/css/**").permitAll()
				.antMatchers("/resources/bootstrap/**").permitAll()
				.antMatchers("/resources/assets/**").permitAll()
				.antMatchers("/resources/jquery/**").permitAll()
				.antMatchers("/resources/fonts/**").permitAll()
				.antMatchers("/resources/images/**").permitAll()
				.antMatchers("/resources/libs/**").permitAll()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/").permitAll()
				// Chỉ có role ADMIN mới được phép vào trang admin .antMatchers("/admin*").hasAnyRole("ADMIN") 
				// Chỉ có role MANAGER mới được phép vào trang admin .antMatchers("/admin*").hasAnyRole("MANAGER")
				.and()
				.formLogin()
				.loginPage("/showMyLoginPage")
				// Tra ve page Admin mac dinh sau khi Login
				.loginProcessingUrl("/authenticateTheUser").defaultSuccessUrl("/admin/")
				.permitAll()
				.and()
				.logout().permitAll().logoutSuccessUrl("/")
				.and()
				// Khi truy cập bị lỗi trả về trang access-denied
				.exceptionHandling().accessDeniedPage("/access-denied");
	}

	// Định nghĩa 1 bean cho userDetailsManager
	@Bean
	public UserDetailsManager userDetailsManager() {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(securityDataSource);
		return jdbcUserDetailsManager;
	}
}
