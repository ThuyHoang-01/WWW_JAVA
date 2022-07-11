package iuh.fit.se.libs;

import org.springframework.beans.factory.annotation.Value;

public class BaseballCoach implements Coach {
	private FortuneService fortuneService;
	@Value("$foo.email")
	private String emailAddress;
	@Value("$foo.team")
	private String team;

	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method - setTeam");
		this.team = team;
	}
}
