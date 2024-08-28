package com.luanvictor.Consultify.modules.admin.entities;

import com.luanvictor.Consultify.core.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrators")
public class Admin extends User {
}
