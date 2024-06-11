package com.andreholman.wiki.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="CATEGORIES")
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="NAME", length=64, nullable=false, unique=true)
    private String name;
    @ManyToMany
    @JoinTable(name = "article_categories",
            joinColumns = @JoinColumn(name = "category_id", nullable=true),
            inverseJoinColumns = @JoinColumn(name = "article_id", nullable=true))
    private Set<Article> articles = new HashSet<Article>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public Set<Article> addArticle(Article newArticle) {
        articles.add(newArticle);
        return articles;
    }
}