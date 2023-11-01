package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product.Size;
import com.jdc.mkt.service.CategoryService;
import com.jdc.mkt.service.ProductService;
import com.jdc.mkt.service.impl.CategoryServiceImpl;
import com.jdc.mkt.service.impl.ProductServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
public class ProductTest {

	static ProductService pService;
	static CategoryService catService;
	
	@BeforeAll
	static void init() {
		pService = new ProductServiceImpl();
		catService = new CategoryServiceImpl();
		pService.clear();
		//catService.clear();
	}
	
	//@ParameterizedTest
	@CsvSource({"1,T-shirt","2,Trouser"})
	@DisplayName("01.insert into category ")
	@Order(1)
	void insertCategory(int id ,String name) {
		var result = catService.insert(new Category(name));
		assertEquals(id,result);
	}
	
	@ParameterizedTest
	@CsvSource({"1,T-shirts","2,Trouser"})
	@DisplayName("01.Update into category ")
	@Order(1)
	void updateCategory(int id ,String name) {
		var cat = new Category(name);
		cat.setId(id);
		cat.setActive(true);
		var result = catService.update(cat);
		assertEquals(1,result);
	}
	
	@ParameterizedTest
	@CsvSource({"1,T-shirts","2,Trouser"})
	@DisplayName("01.Delete into category ")
	@Order(2)
	void deleteCategory(int id ,String name) {
		var cat = new Category(name);
		cat.setId(id);
		cat.setActive(false);
		var result = catService.update(cat);
		assertEquals(1,result);
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/product.csv"
	,delimiter = '\t',
	numLinesToSkip = 1)
	@DisplayName("02.insert into product")
	@Order(3)
	void insertProduct(int id,String name,double price,String size,int catId) {
		var product = new Product(name,price,Size.valueOf(size));
		var category = new Category();
		category.setId(catId);
		product.setCatgory(category);
		var result = pService.insert(product);
		assertEquals(id, result);
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
}
