package com.boot.server.exam.service;

import java.util.Set;

import com.boot.server.exam.models.exammodel.TblCategories;

public interface CategoryService {
	
	public TblCategories addCategory(TblCategories tblCategories);
	
	public TblCategories updateCategory(TblCategories tblCategories);
	
	public Set<TblCategories> getCategories();
	
	public TblCategories getCategoryById(Long categoryId);
	
	public void deleteCategoryById(Long categoryId);

}
