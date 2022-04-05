package com.fullcycle.CatalogoVideo.application.category;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fullcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideo.application.usecase.category.create.CreateCategoryInputData;
import com.fullcycle.CatalogoVideo.application.usecase.category.create.CreateCategoryUseCase;
import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;

@ExtendWith(SpringExtension.class)
public class CreateCategoryUseCaseTests {
	
	@InjectMocks
	private CreateCategoryUseCase useCase;
	
	@Mock
	ICategoryRepository repository;
	
	@BeforeEach
	void initUseCase() {
		useCase = new CreateCategoryUseCase(repository);
	}
	
	@Test
	public void executeReturnscreatedCategory() {
		
		Category category = new Category(
				"Action",
				"Action Category"
		);
		
		Mockito.when(repository.create(ArgumentMatchers.any(Category.class)))
			.thenReturn(category);
		
		CreateCategoryInputData input = new CreateCategoryInputData(
				category.getName(),
				category.getDescription(),
				category.getIsActive()
		);
		
		CategoryOutputData actual = useCase.execute(input);
		
		repository.create(category);
		
		Assertions.assertThat(actual.getName()).isEqualTo(category.getName());
		
	}

}
