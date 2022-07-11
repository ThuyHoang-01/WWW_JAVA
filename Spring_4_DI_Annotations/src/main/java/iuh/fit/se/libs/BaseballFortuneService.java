package iuh.fit.se.libs;

import org.springframework.stereotype.Component;

public class BaseballFortuneService implements FortuneService {
	public String getFortune() {
		return "Today is your baseball game !!";
	}
}
