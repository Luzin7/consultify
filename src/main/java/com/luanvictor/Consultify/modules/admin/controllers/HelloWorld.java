package com.luanvictor.Consultify.modules.admin.controllers;

import com.luanvictor.Consultify.modules.admin.dto.RegisterRequestDTO;
import com.luanvictor.Consultify.modules.admin.services.CreateAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/create")
@ResponseStatus(HttpStatus.CREATED)
@RequiredArgsConstructor
public class CreateAdminController {
    private final CreateAdminService createAdminService;

    public void handle(@RequestBody RegisterRequestDTO body) {
        this.createAdminService.execute(body);
    }
}
