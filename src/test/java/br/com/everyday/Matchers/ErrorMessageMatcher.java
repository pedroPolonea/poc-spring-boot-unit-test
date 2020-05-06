package br.com.everyday.Matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * @author s2it_psilva
 * @version $Revision: $<br/>
 * $Id: $
 * @since 2/26/19 10:33 AM
 */
public class ErrorMessageMatcher<T extends Exception> extends TypeSafeMatcher<T> {

    private String message;

    public ErrorMessageMatcher(final String message) {
        this.message = message;
    }

    public ErrorMessageMatcher match() {
        return new ErrorMessageMatcher(message);
    }

    @Override
    protected boolean matchesSafely(final T item) {
        return item.getMessage().equals(message);
    }

    @Override
    public void describeTo(final Description message) {
    }
}
