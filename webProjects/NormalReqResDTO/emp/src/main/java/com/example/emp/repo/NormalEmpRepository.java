package com.example.emp.repo;

import com.example.emp.entity.NormalEmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NormalEmpRepository extends JpaRepository<NormalEmpEntity, Long> {

    Optional<NormalEmpEntity> findByEmailAndPassword(String email, String password);

}
