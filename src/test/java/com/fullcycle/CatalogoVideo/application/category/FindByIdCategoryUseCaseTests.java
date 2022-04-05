package com.fullcycle.CatalogoVideo.application.category;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fullcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideo.application.usecase.category.get.FindByIdCategoryUseCase;
import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;

@ExtendWith(SpringExtension.class)
public class FindByIdCategoryUseCaseTests {
	
	@InjectMocks
	private FindByIdCategoryUseCase useCase;
	
	@Mock
	ICategoryRepository repository;
	
	@BeforeEach
	void initUseCase() {
		useCase = new FindByIdCategoryUseCase(repository);
	}
	
	@Test
	public void executeAndReturnFindByIdCategory() {
		
		Category categorie = new Category("Sports", "Sports desc", true);
		
		Optional<Category> optionalCategory = Optional.of(categorie);
		
		Mockito.when(repository.findById(categorie.getId()))
			.thenReturn(optionalCategory);
		
		CategoryOutputData actual = useCase.execute(categorie.getId());
		
		repository.findById(categorie.getId());
		
		Assertions.assertThat(optionalCategory).isNotNull();
		
		Assertions.assertThat(actual).isNotNull();
		
	}

}
