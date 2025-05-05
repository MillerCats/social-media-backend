package com.example.reminder.services;

import com.example.reminder.models.Evento;
import com.example.reminder.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    EventoRepository eventoRepository;

    public List<Evento> getEventsByCategory(Integer categoryId) {
        return eventoRepository.getEventsByCategory(categoryId);
    }

    public List<Evento> getEventsByUser(Integer userId) {
        return eventoRepository.getEventsByUser(userId);
    }

    public Evento createEvent(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Evento updateEvent(Integer eventId, Evento evento) {
        Evento foundEvent = eventoRepository.findById(eventId).orElseThrow(() -> new RuntimeException("No se encontró el id del evento"));
        foundEvent.setCategoria(evento.getCategoria());
        foundEvent.setEventTitle(evento.getEventTitle());
        foundEvent.setEventDesc(evento.getEventDesc());
        foundEvent.setEventIn(evento.getEventIn());
        foundEvent.setEventOut(evento.getEventOut());
        return eventoRepository.save(foundEvent);
    }
}
