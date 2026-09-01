package com.example.student.repo;

import com.example.student.entity.CustomStdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomStdRepository extends JpaRepository<CustomStdEntity, Long> {
}
