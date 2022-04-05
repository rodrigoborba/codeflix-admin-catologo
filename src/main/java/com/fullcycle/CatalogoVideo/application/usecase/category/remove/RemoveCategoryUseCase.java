package com.fullcycle.CatalogoVideo.application.usecase.category.remove;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RemoveCategoryUseCase implements IRemoveCategoryUseCase {
	
	private ICategoryRepository repository;

	@Override
	public void execute(UUID id) throws Exception {
		repository.remove(id);
	}

}
