package com.luanvictor.Consultify.modules.inviteToken.entities;

import com.luanvictor.Consultify.shareds.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "professionals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment extends BaseEntity {
    @Column(name = "patient_name")
    private String patientName;
    @Column(name = "professional_id")
    private Long professionalId;
    @Column(name = "appointment_date")
    private LocalDateTime appointmentDate;
    private String status; // 'scheduled', 'completed', 'canceled'
}
