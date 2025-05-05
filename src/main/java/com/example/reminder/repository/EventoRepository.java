package com.example.reminder.repository;

import com.example.reminder.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

    @Query("SELECT e FROM Evento e WHERE e.categoria.categoryId = :categoryId")
    List<Evento> getEventsByCategory(@Param("categoryId") Integer categoryId);

    @Query("SELECT e FROM Evento e WHERE e.categoria.user.userId = :userId")
    List<Evento> getEventsByUser(@Param("userId") Integer userId);
}
