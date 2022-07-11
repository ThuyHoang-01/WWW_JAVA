package iuh.fit.se.libs;

import org.springframework.context.annotation.Bean;

public class BaseballSportConfig {
	@Bean
	public FortuneService happyFortuneService() {
		return new HappyFortuneService();
	}

	@Bean
	public Coach baseballCoach() {
		BaseballCoach baseballCoach = new BaseballCoach(happyFortuneService());
		return baseballCoach;
	}
}
