package com.example.emp.repo;

import com.example.emp.entity.CustomEmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomEmpRepository extends JpaRepository<CustomEmpEntity, Long> {

    Optional<CustomEmpEntity> findByEmailAndPassword(String email, String password);

}
