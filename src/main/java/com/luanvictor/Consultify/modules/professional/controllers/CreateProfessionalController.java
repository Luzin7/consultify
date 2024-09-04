package com.luanvictor.Consultify.modules.professional.controllers;

import com.luanvictor.Consultify.modules.professional.dto.RegisterRequestDTO;
import com.luanvictor.Consultify.modules.professional.services.CreateDoctorService;
import com.luanvictor.Consultify.modules.professional.services.CreateReceptionistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professional")
@ResponseStatus(HttpStatus.CREATED)
@RequiredArgsConstructor
public class CreateProfessionalController {
    private final CreateReceptionistService createReceptionistService;
    private final CreateDoctorService createDoctorService;

    @PostMapping("/create/receptionist")
    public void handleReceptionistCreation(@RequestBody RegisterRequestDTO body) {
        this.createReceptionistService.execute(body);
    }

    @PostMapping("/create/doctor")
    public void handleDoctorCreation(@RequestBody RegisterRequestDTO body) {
        this.createDoctorService.execute(body);
    }
}
