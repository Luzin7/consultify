package com.luanvictor.Consultify.modules.professional.entities;

import com.luanvictor.Consultify.shareds.core.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "professionals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professional extends User {
    private String role; // 'doctor' or 'receptionist'
}
