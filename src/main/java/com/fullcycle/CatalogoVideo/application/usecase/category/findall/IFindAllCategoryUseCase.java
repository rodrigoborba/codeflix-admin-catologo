package com.fullcycle.CatalogoVideo.application.usecase.category.findall;

import java.util.List;

import com.fullcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;

public interface IFindAllCategoryUseCase {
	
	public List<CategoryOutputData> execute();
		

}
