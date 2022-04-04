package com.fullcycle.CatalogoVideo.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fullcycle.CatalogoVideo.domain.exception.DomainException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryTest {
	
	@Test
	public void throwDomainExceptionWhenNameIsNull() {
		Assertions.assertThrows(DomainException.class, () -> new Category(null, "Desc"));
	}
	
	@Test
	public void throwDomainExceptionWhenNameIsBlank() {
		Assertions.assertThrows(DomainException.class, () -> new Category("", "Desc"));
	}
	
	@Test
	public void createCategoryWithName()  {
		
		String nome = "Name 1";
		final Category entity = new Category(
					nome,
					"Description 2"
				);

		assertNotNull(entity);
		assertEquals(entity.getName(), nome);
	}
	
	@Test
	public void createCategoryAndActive()  {
		
		String nome = "Name 1";
		final Category entity = new Category(
					nome,
					"Description 2"
				);

		assertNotNull(entity);
		assertTrue(entity.getIsActive());
	}
	
	@Test
	public void createCategoryAndDeactive()  {
		
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
	public void createCategoryAndUpdate() {
		
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
