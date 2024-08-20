package com.luanvictor.Consultify.repositories.admin;

import com.luanvictor.Consultify.entities.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
