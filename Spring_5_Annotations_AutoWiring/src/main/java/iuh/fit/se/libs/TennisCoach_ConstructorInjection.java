package iuh.fit.se.libs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // Add Component annotation to class
public class TennisCoach_ConstructorInjection implements Coach{
	private FortuneService fortuneService;

	@Autowired // Component injection
	public TennisCoach_ConstructorInjection(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	public String getDailyWorkout() {
		return "Play tennis for 1 hour";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
