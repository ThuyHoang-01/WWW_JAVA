package iuh.fit.se.apps;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import iuh.fit.se.libs.Coach;
import iuh.fit.se.libs.CricketCoach;

public class SpringHelloApp {
	public static void main(String[] args) {
		// Load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Nhan bean tu spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		
		// close context
		context.close();
	}
}
