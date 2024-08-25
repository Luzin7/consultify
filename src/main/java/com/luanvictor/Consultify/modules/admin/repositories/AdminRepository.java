package com.luanvictor.Consultify.modules.admin.repositories;

import com.luanvictor.Consultify.modules.admin.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
}
