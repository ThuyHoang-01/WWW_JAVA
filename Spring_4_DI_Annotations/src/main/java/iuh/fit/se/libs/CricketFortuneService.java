package iuh.fit.se.libs;

import org.springframework.stereotype.Component;

public class CricketFortuneService implements FortuneService {
	public String getFortune() {
		return "Today is your Cricket game !! Good luck";
	}
}
