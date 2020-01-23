package com.diego.saez.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test Case for {@link MapperException}
 * 
 * @author diegosaez
 *
 */
public class MapperExceptionTest {

	/**
	 * Positive case for MapperException()
	 */
	@Test
	public void testMapperException() {
		MapperException mapperException = new MapperException();
		Assertions.assertNotNull(mapperException);
	}

	/**
	 * Positive case for MapperExceptionString(message)
	 */
	@Test
	public void testMapperExceptionString() {
		MapperException mapperException = new MapperException("Error");
		Assertions.assertNotNull(mapperException);
		Assertions.assertEquals("Error", mapperException.getMessage());
	}

}
