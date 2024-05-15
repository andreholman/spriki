package com.andreholman.wiki.controller;

import com.andreholman.wiki.model.Category;
import com.andreholman.wiki.repository.CategoryRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/category", consumes="application/json")
public class CategoryController {
	@Autowired
    private CategoryRepository categoryRepository;

	@Autowired
    private ObjectMapper objectMapper;

	@PostMapping
	public ResponseEntity<Category> newCategory(@RequestBody Category category) {
		try {
            // Convert Category object to JSON string and log it
            String categoryJson = objectMapper.writeValueAsString(category);
            System.out.println("Received JSON Payload: " + categoryJson);

            // Your existing logic to save the category
            Category savedCategory = categoryRepository.save(category);
            return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle JSON conversion exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
}