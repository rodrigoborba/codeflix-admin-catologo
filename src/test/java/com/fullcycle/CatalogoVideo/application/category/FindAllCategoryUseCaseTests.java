package com.fullcycle.CatalogoVideo.application.category;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fullcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideo.application.usecase.category.findall.FindAllCategoryUseCase;
import com.fullcycle.CatalogoVideo.application.usecase.category.findall.IFindAllCategoryUseCase;
import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;

@ExtendWith(SpringExtension.class)
public class FindAllCategoryUseCaseTests {
	
	@InjectMocks
	private FindAllCategoryUseCase useCase;
	
	@Mock
	ICategoryRepository repository;
	
	@BeforeEach
	void initUseCase() {
		useCase = new FindAllCategoryUseCase(repository);
	}
	
	@Test
	public void executeAndReturnFinAllCategory() {
		
		List<Category> categories = Arrays.asList(
				new Category("Sports", "Sports desc", true),
				new Category("Action", "Action desc", true),
				new Category("Suspense", "Suspense desc", true)
		);
		
		Mockito.when(repository.findAll())
			.thenReturn(categories);
		
		List<CategoryOutputData> actual = useCase.execute();
		
		repository.findAll();
		
		Assertions.assertThat(categories).isNotNull();
		Assertions.assertThat(categories).hasSize(3);
		
		verify(repository, times(2)).findAll();
		
		Assertions.assertThat(actual).isNotNull();
		Assertions.assertThat(actual).hasSize(3);
		
	}

}
