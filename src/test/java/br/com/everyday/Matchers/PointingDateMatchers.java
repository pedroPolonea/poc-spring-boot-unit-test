package br.com.everyday.Matchers;

import java.time.LocalDateTime;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;



public class PointingDateMatchers extends TypeSafeMatcher<LocalDateTime>{
	
	private LocalDateTime toCompareDate;
	
	public PointingDateMatchers(LocalDateTime toCompareDate) {
		this.toCompareDate = toCompareDate;
	}
	
	public void describeTo(Description desc) {
		desc.appendText(toCompareDate.toString());	
	}

	@Override
	protected boolean matchesSafely(LocalDateTime date) {
		return date.isBefore(toCompareDate);
	}


}
