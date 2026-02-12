package com.creativegym.backend.repository;

import com.creativegym.backend.model.DietTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietTemplateRepository extends JpaRepository<DietTemplate, Long> {
}
