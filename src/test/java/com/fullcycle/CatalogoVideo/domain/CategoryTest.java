package com.fullcycle.CatalogoVideo.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryTest {
	
	@Test
	public void createCategoryWithName() throws Exception {
		
		String nome = "Name 1";
		final Category entity = new Category(
					nome,
					"Description 2"
				);

		assertNotNull(entity);
		assertEquals(entity.getName(), nome);
	}
	
	@Test
	public void createCategoryAndActive() throws Exception {
		
		String nome = "Name 1";
		final Category entity = new Category(
					nome,
					"Description 2"
				);

		assertNotNull(entity);
		assertTrue(entity.getIsActive());
	}
	
	@Test
	public void createCategoryAndDeactive() throws Exception {
		
		String nome = "Name 1";
		final Category entity = new Category(
					nome,
					"Description 2"
				);
		entity.deactive();
		
		assertNotNull(entity);
		assertFalse(entity.getIsActive());
	}
	
	@Test
	public void createCategoryAndUpdate() throws Exception {
		
		String nome = "Name 1";
		final Category entity = new Category(
					nome,
					"Description 2"
				);
		
		assertNotNull(entity);
		assertEquals(entity.getName(), nome);
		
		String nomeAtualizado = "Name 2";
		entity.update(nomeAtualizado, "Desc", false);	
		
		assertNotNull(entity);
		assertEquals(entity.getName(), nomeAtualizado);
		assertFalse(entity.getIsActive());
	}

}
