package com.luanvictor.Consultify.modules.professional.repositories;

import com.luanvictor.Consultify.modules.professional.entities.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    Optional<Professional> findByEmail(String email);
}
