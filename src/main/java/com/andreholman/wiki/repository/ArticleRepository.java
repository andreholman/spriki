package com.andreholman.wiki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andreholman.wiki.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    
}