package com.luanvictor.Consultify.modules.admin.domains;

import com.luanvictor.Consultify.shareds.core.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrators")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class Admin extends User {
}
