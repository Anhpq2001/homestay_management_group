package com.example.homestaymanagementgroup_four.repository;

import com.example.homestaymanagementgroup_four.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
