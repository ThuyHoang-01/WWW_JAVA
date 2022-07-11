package iuh.fit.se.libs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // Add Component annotation to class
public class TrackCoach_FieldInjection implements Coach {
	@Autowired // Field injection
	private FortuneService fortuneService;

	public TrackCoach_FieldInjection(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	public String getDailyWorkout() {
		return "Play tracking for 2 hours";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
