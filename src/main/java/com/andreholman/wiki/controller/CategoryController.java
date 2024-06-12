package com.andreholman.wiki.controller;

import com.andreholman.wiki.model.Category;
import com.andreholman.wiki.repository.CategoryRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostMapping(value = "/category", consumes = "application/json")
	public ResponseEntity<Category> newCategory(@RequestBody Category category) {
		Category savedCategory = categoryRepository.save(category);
		return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
	}

	@GetMapping("/category/{name}")
    public ResponseEntity<Category> getCategoryByName(@PathVariable String name) {
        Optional<Category> category = categoryRepository.findByName(name);
        if (category.isPresent()) {
            return new ResponseEntity<>(category.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	// @PutMapping(value = "/category/{name}", consumes = "application/json")
    // public ResponseEntity<Category> updateCategory(@PathVariable String name, @RequestBody Category categoryDetails) {
	// 	Optional<Category> category = categoryRepository.findByName(name);
	// 	if (category.isPresent()) {
			
	// 	}
    // }

	@DeleteMapping("/category/{name}")
	public ResponseEntity<Void> deleteCategory(@PathVariable String name) {
		if (categoryRepository.existsByName(name)) { // instead of isPresent because contents doesn't matter.
            categoryRepository.deleteByName(name);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
}