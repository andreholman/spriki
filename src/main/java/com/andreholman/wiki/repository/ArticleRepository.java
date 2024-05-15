package com.andreholman.wiki.repository;

import org.springframework.data.repository.CrudRepository;

import com.andreholman.wiki.model.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    
}