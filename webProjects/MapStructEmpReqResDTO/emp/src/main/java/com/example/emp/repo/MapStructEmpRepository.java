package com.example.emp.repo;

import com.example.emp.entity.MapStructEmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

public interface MapStructEmpRepository extends JpaRepository<MapStructEmpEntity, Long> {

    Optional<MapStructEmpEntity> findByEmailAndPassword(String email, String password);

}
