package com.example.reminder.controllers;

import com.example.reminder.models.Evento;
import com.example.reminder.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {
    @Autowired
    EventoService eventoService;

    @GetMapping("getEventsByUser/{userId}")
    public ResponseEntity<Object> getEventsByUser(@PathVariable Integer userId) {
        List<Evento> eventos = eventoService.getEventsByUser(userId);
        if (!eventos.isEmpty()) {
            return ResponseEntity.ok(eventos);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Categoría vacía");
        }
    }

    @GetMapping("getEventsByCategory/{categoryId}")
    public ResponseEntity<Object> getEventsByCategory(@PathVariable Integer categoryId) {
        List<Evento> eventos = eventoService.getEventsByCategory(categoryId);
        if (!eventos.isEmpty()) {
            return ResponseEntity.ok(eventos);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Categoría vacía");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createEvent(@RequestBody Evento evento) {
        try {
            Evento createdEvent = eventoService.createEvent(evento);
            return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear evento: " + e);
        }
    }

    @PutMapping("/updateEvent/{eventId}")
    public ResponseEntity<Object> updateEvent(@PathVariable Integer eventId, @RequestBody Evento evento) {
        try {
            Evento updatedEvent = eventoService.updateEvent(eventId, evento);
            return ResponseEntity.ok(updatedEvent);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar evento: " + e);
        }
    }
}
