package com.andreholman.wiki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.andreholman.wiki.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
    boolean existsByName(String name);
    void deleteByName(String name);
}
