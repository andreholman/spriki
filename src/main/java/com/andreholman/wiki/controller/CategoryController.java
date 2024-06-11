package com.andreholman.wiki.controller;

import com.andreholman.wiki.model.Category;
import com.andreholman.wiki.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping()

	@PostMapping(value = "/category", consumes = "application/json")
	public ResponseEntity<Category> newCategory(@RequestBody Category category) {
		Category savedCategory = categoryRepository.save(category);
		return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
	}
	
}