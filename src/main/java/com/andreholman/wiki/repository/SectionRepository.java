package com.andreholman.wiki.repository;

import org.springframework.data.repository.CrudRepository;

import com.andreholman.wiki.model.Section;

public interface SectionRepository extends CrudRepository<Section, Long> {
    
}

