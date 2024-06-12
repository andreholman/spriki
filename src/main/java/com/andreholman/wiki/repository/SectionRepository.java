package com.andreholman.wiki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andreholman.wiki.model.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
    
}

