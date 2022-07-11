package iuh.fit.se.libs;

import org.springframework.stereotype.Component;

@Component("theSillyCoach") // Them Component anotation vao truoc Class
public class TennisCoach implements Coach {
	public String getDailyWorkout() {
		return "Play tennis for 1 hour";
	}
}
