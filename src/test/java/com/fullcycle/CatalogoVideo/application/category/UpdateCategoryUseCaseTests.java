package com.fullcycle.CatalogoVideo.application.category;

import static org.assertj.core.api.Assertions.in;
import static org.mockito.Mockito.doNothing;

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
import com.fullcycle.CatalogoVideo.application.usecase.category.update.UpdateCategoryInputData;
import com.fullcycle.CatalogoVideo.application.usecase.category.update.UpdateCategoryUseCase;
import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;

@ExtendWith(SpringExtension.class)
public class UpdateCategoryUseCaseTests {
	
	@InjectMocks
	private UpdateCategoryUseCase useCase;
	
	@Mock
	ICategoryRepository repository;
	
	@BeforeEach
	void initUseCase() {
		useCase = new UpdateCategoryUseCase(repository);
	}
	
	@Test
	public void executeAndReturnUpdatedCategory() {
		
		Category categorie = new Category("Sports", "Sports desc", true);
		
		Category expected = new Category("Sports 2", "Sports desc", true);
		
		Optional<Category> optionalCategory = Optional.of(categorie);
		
		Mockito.when(repository.findById(categorie.getId()))
			.thenReturn(optionalCategory);
		
		UpdateCategoryInputData input = new UpdateCategoryInputData();
		input.setName("Sports 2");
		input.setDescription("Sport desc");
		input.setIsActive(categorie.getIsActive());
		
		categorie.update(input.getName(), input.getDescription(), input.getIsActive());
		
		doNothing()
			.when(repository)
			.update(categorie);
		
		useCase.execute(categorie.getId(), input);
		
		repository.findById(categorie.getId());
		
		Assertions.assertThat(categorie).isNotNull();
		Assertions.assertThat(expected).isNotNull();
		Assertions.assertThat(categorie.getName()).isEqualTo(expected.getName());
		
	}

}
