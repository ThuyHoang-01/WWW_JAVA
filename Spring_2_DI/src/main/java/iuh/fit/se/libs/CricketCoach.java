package iuh.fit.se.libs;

public class CricketCoach implements Coach {
	private String emailAddress;
	private String team;

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

	private FortuneService fortuneService;

	public void setFortuneService(FortuneService fortuneService) {
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
