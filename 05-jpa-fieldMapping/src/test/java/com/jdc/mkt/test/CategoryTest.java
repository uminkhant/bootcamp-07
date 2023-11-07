package com.jdc.mkt.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.entity.Category;

public class CategoryTest extends JpaFactory{

	
	@ParameterizedTest
	@ValueSource(strings="Foods")
	void testInsert(String name) {
		var category = new Category(name);	
		em.getTransaction().begin();
		em.persist(category);
		em.getTransaction().commit();
		
	}
	
}
