package com.se.nuochoa.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.se.nuochoa")
@PropertySource({"classpath:persistence-mssql.properties",
"classpath:security-persistence-mssql.properties"})
public class AppConfig implements WebMvcConfigurer {
	@Autowired
	private Environment env;
	private Logger logger = Logger.getLogger(getClass().getName());

	// Định nghĩa 1 bean cho ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	// Tạo datasource để kết nối DB
	@Bean
	public DataSource myDataSource() {
		// Tạo connection pool
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();
		// Cài đặt jdbc driver
		try {
			myDataSource.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		// Logging đảm bảo đọc được data
		logger.info("jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info("jdbc.user=" + env.getProperty("jdbc.user"));
		
		// Cài đặt database connection credential
		myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		myDataSource.setUser(env.getProperty("jdbc.user"));
		myDataSource.setPassword(env.getProperty("jdbc.password"));

		// Cài đặt connection pool
		myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return myDataSource;
	}

	private Properties getHibernateProperties() {
		// Cài đặt hibernate properties
		Properties props = new Properties();

		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

		return props;
	}

	// Định nghĩa 1 bean cho Security datasource
	@Bean
	public DataSource securityDataSource() {
		// Tạo connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

		// Cài đặt jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("security.jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}

		// Logging đảm bảo connection
		// Đảm bảo đọc được data từ properties file
		logger.info(">>> security.jdbc.url=" + env.getProperty("security.jdbc.url"));
		logger.info(">>> security.jdbc.user=" + env.getProperty("security.jdbc.user"));

		// Cài đặt database connection credential
		securityDataSource.setJdbcUrl(env.getProperty("security.jdbc.url"));
		securityDataSource.setUser(env.getProperty("security.jdbc.user"));
		securityDataSource.setPassword(env.getProperty("security.jdbc.password"));

		// Cài đặt database connection pool 
		securityDataSource.setInitialPoolSize(getIntProperty("security.connection.pool.initialPoolSize"));

		securityDataSource.setMinPoolSize(getIntProperty("security.connection.pool.minPoolSize"));

		securityDataSource.setMaxPoolSize(getIntProperty("security.connection.pool.maxPoolSize"));

		securityDataSource.setMaxIdleTime(getIntProperty("security.connection.pool.maxIdleTime"));

		return securityDataSource;
	}

	// Cần phải có helpe method này
	// Để đọc environment property và chuyển sand dạng int
	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);

		int intPropVal = Integer.parseInt(propVal); // Chuyển đổi sange int

		return intPropVal;
	}

	// Định nghĩa 1 bean cho Session Factory
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		// Tạo session factories
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		// Thiếp lập các cấu hình 
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}

	// Định nghĩa 1 bean cho Hibernate Transaction
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		// Cài đặt transaction manager dựa trên session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}

	// Tạo nơi quản lý các resources
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

}
