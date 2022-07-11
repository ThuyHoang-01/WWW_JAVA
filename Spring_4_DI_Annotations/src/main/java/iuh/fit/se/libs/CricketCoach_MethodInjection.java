package iuh.fit.se.libs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // Add Component annotation to class
public class CricketCoach_MethodInjection implements Coach {
	public CricketCoach_MethodInjection() {
		System.out.println(">> cricketCoach: inside default constructor");
	}

	private FortuneService fortuneService;

	@Autowired    // Method injection
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println(">> cricketCoach: inside setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Autowired    // Method injection
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println(">> cricketCoach: inside doSomeCrazyStuff");
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout() {
		return "Run 1000 meters around yard";
	}

	public String getDailyFortune() {
		// Su dung forturnService de get fortune
		return fortuneService.getFortune();
	}
}
