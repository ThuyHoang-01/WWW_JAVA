package iuh.fit.se.libs;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // Add Component annotation to class
public class BaseballCoach implements Coach {
	private FortuneService fortuneService;

	public BaseballCoach() {
		System.out.println(">> baseballCoach: inside default constructor");
	}

	@Autowired // Setter injection
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> baseballCoach: inside setFortuneService");
		fortuneService = theFortuneService;
	}

	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> baseballCoach: inside method doMyStartupStuff");
	}

	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> baseballCoach: inside method doMyCleanupStuff");
	}
}
