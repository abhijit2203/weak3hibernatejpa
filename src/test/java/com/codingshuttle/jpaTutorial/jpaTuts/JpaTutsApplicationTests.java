package com.codingshuttle.jpaTutorial.jpaTuts;

import com.codingshuttle.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.codingshuttle.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutsApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity productEntity=ProductEntity.builder()
				.sku("nestle234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(23.45))
				.quantity(4)
				.build();

		ProductEntity savProductEntity=productRepository.save(productEntity);
		System.out.println(savProductEntity);

	}

	@Test
	void getRepository(){
//		List<ProductEntity> entitis= productRepository.findByCreatedAtAfter(LocalDateTime.of(2024,1,1,0,0,0));
//		System.out.println(entitis);

//		List<ProductEntity> entitis= productRepository.findByQuantityGreaterThanOrPriceLessThan(4,BigDecimal.valueOf(23.45));
//		System.out.println(entitis);

//		List<ProductEntity> entitis= productRepository.findByTitleLike("%Choco%");
//		System.out.println(entitis);

//		List<ProductEntity> entitis= productRepository.findByTitleContaining("Choco");
//		System.out.println(entitis);

		List<ProductEntity> entitis= productRepository.findByTitleContainingIgnoreCase("choco");
		System.out.println(entitis);


	}

//	@Test
//	void getSingleFromRepository(){
//		Optional<ProductEntity> productEntity= productRepository
//				.findByTitleAndPrice("pepsi", BigDecimal.valueOf(12.8));
//		productEntity.ifPresent(System.out::println);
//	}

	@Test
	void getSingleFromRepository(){
		Optional<String> productEntity= productRepository
				.findByTitleAndPrice("pepsi", BigDecimal.valueOf(12.8));
		productEntity.ifPresent(System.out::println);
	}

}
