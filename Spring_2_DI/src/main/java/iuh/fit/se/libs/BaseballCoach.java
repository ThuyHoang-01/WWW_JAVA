package iuh.fit.se.libs;

public class BaseballCoach implements Coach{
	
	// Tao private field cho dependency
	private FortuneService fortuneService;

	// Tao contructor cho depency injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	public String getDailyFortune() {
		// Su dung forturnService de get fortune
		return fortuneService.getFortune();
	}

}
