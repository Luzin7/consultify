package com.luanvictor.Consultify.modules.admin.repositories;

import com.luanvictor.Consultify.modules.admin.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
