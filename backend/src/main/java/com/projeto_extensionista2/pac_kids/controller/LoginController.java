package com.projeto_extensionista2.pac_kids.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public ResponseEntity<Boolean> login(@RequestParam String username, @RequestParam
    String password) {

        return ResponseEntity.ok(true);
    }

}
