package com.diego.saez.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test Case for {@link WebException}.
 * 
 * @author diegosaez
 *
 */
public class WebExceptionTest {

	/**
	 * Positive case for WebException().
	 */
	@Test
	public void testWebException() {
		WebException webException = new WebException();
		Assertions.assertNotNull(webException);
	}

	/**
	 * Positive case for WebException(message).
	 */
	@Test
	public void testWebExceptionString() {
		WebException webException = new WebException("Error");
		Assertions.assertEquals("Error", webException.getMessage());
	}

}
