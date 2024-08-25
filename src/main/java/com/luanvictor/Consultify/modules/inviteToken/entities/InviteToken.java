package com.luanvictor.Consultify.modules.inviteToken.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "invite_tokens")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InviteToken {
    @Id
    private String token;
    @Column(name = "admin_id")
    private Long adminId;
    private String role; // 'doctor' or 'receptionist'
    private LocalDateTime expiration;
//    private boolean used;
}
