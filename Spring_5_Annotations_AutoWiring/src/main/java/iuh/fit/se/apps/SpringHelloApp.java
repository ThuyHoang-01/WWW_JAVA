package iuh.fit.se.apps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import iuh.fit.se.libs.Coach;

public class SpringHelloApp {
	public static void main(String[] args) {
		Coach theCoach;

		// Load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Nhan bean tu spring container
		theCoach = context.getBean("baseballCoach_SetterInjection", Coach.class);
		// Goi phuong thuc get daily fortune
		System.out.println(theCoach.getDailyFortune());

		// Nhan bean tu spring container
		theCoach = context.getBean("cricketCoach_MethodInjection", Coach.class);
		// Goi phuong thuc get daily fortune
		System.out.println(theCoach.getDailyFortune());

		// Nhan bean tu spring container
		theCoach = context.getBean("tennisCoach_ConstructorInjection", Coach.class);
		// Goi phuong thuc get daily fortune
		System.out.println(theCoach.getDailyFortune());

		// Nhan bean tu spring container
		theCoach = context.getBean("trackCoach_FieldInjection", Coach.class);
		// Goi phuong thuc get daily fortune
		System.out.println(theCoach.getDailyFortune());

		// close context
		context.close();
	}
}
