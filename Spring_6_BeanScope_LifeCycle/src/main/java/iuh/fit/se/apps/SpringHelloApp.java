package iuh.fit.se.apps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import iuh.fit.se.libs.Coach;

public class SpringHelloApp {
	public static void main(String[] args) {
		Coach theCoach;

		// Load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Nhan bean tu spring container
		theCoach = context.getBean("baseballCoach", Coach.class);
		// Goi phuong thuc get daily workout
		System.out.println(theCoach.getDailyWorkout());
		// Goi phuong thuc get daily fortune
		System.out.println(theCoach.getDailyFortune());

		// close context
		context.close();
	}
}
