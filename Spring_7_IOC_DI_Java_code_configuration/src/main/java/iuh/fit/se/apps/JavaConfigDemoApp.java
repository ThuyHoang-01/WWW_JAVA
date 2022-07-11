package iuh.fit.se.apps;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import iuh.fit.se.libs.BaseballCoach;
import iuh.fit.se.libs.Coach;
import iuh.fit.se.libs.SportConfig;

public class JavaConfigDemoApp {
	public static void main(String[] args) {
		// Doc Spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// Nhan bean tu spring container
		BaseballCoach baseballCoach = context.getBean("baseballCoach", BaseballCoach.class);
		// Goi phuong thuc get daily workout
		System.out.println(baseballCoach.getDailyWorkout());
		// Goi phuong thuc get daily fortune
		System.out.println(baseballCoach.getDailyFortune());

		// close context
		context.close();
	}
}
