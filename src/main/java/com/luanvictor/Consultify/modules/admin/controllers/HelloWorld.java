package com.luanvictor.Consultify.modules.admin.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@ResponseStatus(HttpStatus.OK)
public class HelloWorld {
    @GetMapping("/hello")
    public ResponseEntity<String> handle() {
        return ResponseEntity.ok("Hello World");
    }
}
