package com.diego.saez.model.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.diego.saez.model.Category;

/**
 * Test Case para {@link CategoryBuilder}
 * 
 * @author diegosaez
 *
 */
public class CategoryBuilderTest {

	@Test
	public void testBuild() {
		CategoryBuilder categoryBuilder = CategoryBuilder.getInstance();
		Category category = categoryBuilder.withId(2L).withName("Name").build();
		Assertions.assertNotNull(category);
		Assertions.assertNotNull(category.getId());
		Assertions.assertNotNull(category.getName());
		Assertions.assertEquals(2L, category.getId());
		Assertions.assertEquals("Name", category.getName());
	}

}
