package com.fullcycle.CatalogoVideo.application.category;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fullcycle.CatalogoVideo.application.usecase.category.remove.RemoveCategoryUseCase;
import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;

@ExtendWith(SpringExtension.class)
public class RemoveCategoryUseCaseTests {
	
	@InjectMocks
	private RemoveCategoryUseCase useCase;
	
	@Mock
	ICategoryRepository repository;
	
	@BeforeEach
	void initUseCase() {
		useCase = new RemoveCategoryUseCase(repository);
	}
	
	@Test
	public void executeRemoveCategory() throws Exception {
		
		Category category = new Category("Sports", "Sports desc", true);
		
		Mockito.doNothing()
			.when(repository)
			.remove(category.getId());
		
		useCase.execute(category.getId());
		repository.remove(category.getId());
		
		Assertions.assertThat(category).isNotNull();
		verify(repository, times(2)).remove(category.getId());
		
	}

}
