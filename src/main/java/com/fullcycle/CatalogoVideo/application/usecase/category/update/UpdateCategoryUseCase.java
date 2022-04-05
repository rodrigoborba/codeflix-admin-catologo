package com.fullcycle.CatalogoVideo.application.usecase.category.update;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fullcycle.CatalogoVideo.application.exception.NotFoundException;
import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UpdateCategoryUseCase implements IUpdateCategoryUseCase {
	
	private ICategoryRepository repository;

	@Override
	public void execute(UUID id, UpdateCategoryInputData input) {
		Category category = repository.findById(id)
			.orElseThrow(() -> new NotFoundException("Category %$ not found", id));
		
		category.update(input.getName(), input.getDescription(), input.getIsActive());
		
		repository.update(category);
	}

}
