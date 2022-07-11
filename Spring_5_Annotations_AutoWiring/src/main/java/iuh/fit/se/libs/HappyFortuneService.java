package iuh.fit.se.libs;

import org.springframework.stereotype.Component;

@Component // Add Component annotation to class
public class HappyFortuneService implements FortuneService {

	public String getFortune() {
		return "Today is your lucky day!";
	}

}
