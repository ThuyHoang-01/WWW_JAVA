package iuh.fit.se.libs;

import org.springframework.stereotype.Component;

@Component("niceCoach")
public class CricketCoach implements Coach {
	public String getDailyWorkout() {
		return "Run 1200 meters";
	}
}
