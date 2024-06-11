package com.andreholman.wiki.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ARTICLES")
public class Article {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToMany(mappedBy = "articles")
    private Set<Category> categories = new HashSet<Category>();

    @Column(name="TITLE", length=64, nullable=false, unique=false)
    private String title;
    @Column(name="DESCRIPTION", length=64, nullable=false, unique=true)
    private String description;
    @OneToMany(mappedBy="article", cascade=CascadeType.PERSIST)
    private Set<Section> contents = new HashSet<Section>();

    public Article() {}

    public String getTitle() {
        return this.title;
    }
    
    public Set<Category> getCategories() {
        return this.categories;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean setTitle(String title) {
        this.title = title;
        return true; // Validate title in the future.
    }

    public boolean setDescription(String description) {
        this.description = description;
        return true; // Validate description in the future.
    }
    
    public Set<Section> getContents() {
        return contents;
    }

    public Set<Section> addSection(Section newSection) {
        contents.add(newSection);
        return contents;
    }
}
