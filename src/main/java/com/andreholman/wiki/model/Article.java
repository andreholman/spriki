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
}
