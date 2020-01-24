package com.diego.saez.dto.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.diego.saez.dto.CategoryDto;

/**
 * Test Case for {@link CategoryDtoBuilder}.
 * 
 * @author diegosaez
 *
 */
public class CategoryDtoBuilderTest {

	/**
	 * Positive case for build().
	 */
	@Test
	public void testBuild() {
		CategoryDtoBuilder categoryDtoBuilder = CategoryDtoBuilder.getInstance();
		CategoryDto categoryDto = categoryDtoBuilder.withId(2L).withName("Name").build();
		Assertions.assertNotNull(categoryDto);
		Assertions.assertNotNull(categoryDto.getId());
		Assertions.assertNotNull(categoryDto.getName());
		Assertions.assertEquals(2L, categoryDto.getId());
		Assertions.assertEquals("Name", categoryDto.getName());
	}

}
