package com.diego.saez.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test Case for {@link BussinessException}
 * 
 * @author diegosaez
 *
 */
public class BussinessExceptionTest {

	/**
	 * Positive case for BussinessException()
	 */
	@Test
	public void testBussinessException() {
		BussinessException bussinessException = new BussinessException();
		Assertions.assertNotNull(bussinessException);
	}

	/**
	 * Positive case for BussinessException(message,cause)
	 */
	@Test
	public void testBussinessExceptionStringThrowable() {
		BussinessException bussinessException = new BussinessException("Error", new Exception());
		Assertions.assertNotNull(bussinessException);
		Assertions.assertNotNull(bussinessException.getMessage());
		Assertions.assertNotNull(bussinessException.getCause());
		Assertions.assertEquals("Error", bussinessException.getMessage());
	}

	/**
	 * Positive case for BussinessException(message)
	 */
	@Test
	public void testBussinessExceptionString() {
		BussinessException bussinessException = new BussinessException("Error");
		Assertions.assertNotNull(bussinessException);
		Assertions.assertNotNull(bussinessException.getMessage());
		Assertions.assertEquals("Error", bussinessException.getMessage());
	}

}
