package com.boot.server.exam.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.server.exam.models.exammodel.TblCategories;
import com.boot.server.exam.service.CategoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//add category
	@PostMapping("/")
	public ResponseEntity<TblCategories> addCategory(@RequestBody TblCategories tblCategories){
		TblCategories addCategory = this.categoryService.addCategory(tblCategories);
		return ResponseEntity.ok(addCategory);
	}
	
	//get category by id
	@GetMapping("/{categoryId}")
	public TblCategories getCategoryById(@PathVariable("categoryId") Long categoryId) {
		return this.categoryService.getCategoryById(categoryId);
	}
	
	//get all category
	@GetMapping("/")
	public ResponseEntity<?> getAllCategory(){
		return ResponseEntity.ok(this.categoryService.getCategories());
	}

	//update category
	@PutMapping("/")
	public TblCategories updateCategory(@RequestBody TblCategories tblCategories) {
	    return this.categoryService.updateCategory(tblCategories);
	}
	
	//delete category by id
	@DeleteMapping("/{categoryId}")
	public void deleteCategoryById(@PathVariable("categoryId") Long categoryId) {
		this.categoryService.deleteCategoryById(categoryId);
	}
	
}
