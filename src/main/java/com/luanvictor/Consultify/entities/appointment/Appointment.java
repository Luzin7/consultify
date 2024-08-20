package com.luanvictor.Consultify.entities.appointment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "professionals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "patient_name")
    private String patientName;
    @Column(name = "professional_id")
    private Long professionalId;
    @Column(name = "appointment_date")
    private LocalDateTime appointmentDate;
    private String status; // 'scheduled', 'completed', 'canceled'
}
