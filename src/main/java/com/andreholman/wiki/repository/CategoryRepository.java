package com.andreholman.wiki.repository;

import org.springframework.data.repository.CrudRepository;

import com.andreholman.wiki.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    
}
