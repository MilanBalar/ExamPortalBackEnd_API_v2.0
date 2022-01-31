package com.boot.server.exam.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.server.exam.models.exammodel.TblCategories;
import com.boot.server.exam.repository.CategoryRepository;
import com.boot.server.exam.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public TblCategories addCategory(TblCategories tblCategories) {
		
		return this.categoryRepository.save(tblCategories);
	}

	@Override
	public TblCategories updateCategory(TblCategories tblCategories) {
		
		return this.categoryRepository.save(tblCategories);
	}

	@Override
	public Set<TblCategories> getCategories() {
		
		return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public TblCategories getCategoryById(Long categoryId) {
		
		return this.categoryRepository.findById(categoryId).get();
	}

	@Override
	public void deleteCategoryById(Long categoryId) {
		
		this.categoryRepository.deleteById(categoryId);

	}

}
