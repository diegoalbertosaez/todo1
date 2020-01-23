package com.diego.saez.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test Case para {@link MapperException}
 * 
 * @author diegosaez
 *
 */
public class MapperExceptionTest {

	/**
	 * Caso positivo para MapperException()
	 */
	@Test
	public void testMapperException() {
		MapperException mapperException = new MapperException();
		Assertions.assertNotNull(mapperException);
	}

	/**
	 * Caso positivo MapperExceptionString(message)
	 */
	@Test
	public void testMapperExceptionString() {
		MapperException mapperException = new MapperException("Error");
		Assertions.assertNotNull(mapperException);
		Assertions.assertEquals("Error", mapperException.getMessage());
	}

}
