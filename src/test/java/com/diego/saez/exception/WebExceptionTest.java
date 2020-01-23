package com.diego.saez.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test Case para {@link WebException}
 * 
 * @author diegosaez
 *
 */
public class WebExceptionTest {

	@Test
	public void testWebException() {
		WebException webException = new WebException();
		Assertions.assertNotNull(webException);
	}

	@Test
	public void testWebExceptionString() {
		WebException webException = new WebException("Error");
		Assertions.assertEquals("Error", webException.getMessage());
	}

}
