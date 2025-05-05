package com.example.reminder.controllers;

import com.example.reminder.models.Usuario;
import com.example.reminder.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody Usuario usuario) {
        Usuario foundUser = usuarioService.loginUser(usuario);
        if (foundUser != null) {
            return ResponseEntity.ok(foundUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No se encontró usuario");
        }
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<Object> getUserById(@PathVariable Integer userId) {
        Usuario foundUser = usuarioService.getUserById(userId);
        if (foundUser != null) {
            return ResponseEntity.ok(foundUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No se encontró usuario");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signUpUser(@RequestBody Usuario usuario) {
        try {
            Usuario createdUser = usuarioService.signUpUser(usuario);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear cuenta: " + e, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateDataUser/{userId}")
    public ResponseEntity<Object> updateDataUser(@PathVariable Integer userId, @RequestBody Usuario usuario) {
        try {
            Usuario updatedUser = usuarioService.updateUser(userId, usuario);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar: " + e);
        }
    }


}
