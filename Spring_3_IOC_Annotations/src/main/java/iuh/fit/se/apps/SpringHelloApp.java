package iuh.fit.se.apps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import iuh.fit.se.libs.Coach;

public class SpringHelloApp {
	public static void main(String[] args) {
		Coach theCoach;

		// Load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Nhan bean tu spring container
		theCoach = context.getBean("theSillyCoach", Coach.class); // Nhan bean tu Component annotation
		System.out.println(theCoach.getDailyWorkout());

		// Nhan bean tu spring container
		theCoach = context.getBean("niceCoach", Coach.class); // Nhan bean tu Component annotation
		System.out.println(theCoach.getDailyWorkout());

		// Nhan bean tu spring container
		theCoach = context.getBean("baseballCoach", Coach.class); // Nhan bean tu Default Component Bean ID (Quy tac:
																	// chu dau tien cua class viet thuong)
		System.out.println(theCoach.getDailyWorkout());

		// close context
		context.close();
	}
}
