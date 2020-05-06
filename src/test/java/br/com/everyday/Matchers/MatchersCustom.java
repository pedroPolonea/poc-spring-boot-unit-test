package br.com.everyday.Matchers;

import java.time.LocalDateTime;

public class MatchersCustom {
	
	public static PointingDateMatchers isBefore(LocalDateTime localDateTime) {
		return new PointingDateMatchers(localDateTime);
	}
}
