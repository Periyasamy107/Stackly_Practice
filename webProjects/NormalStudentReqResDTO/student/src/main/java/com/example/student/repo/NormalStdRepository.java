package com.example.student.repo;

import com.example.student.entity.NormalStdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NormalStdRepository extends JpaRepository<NormalStdEntity, Long> {
}
