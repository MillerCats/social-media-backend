package com.example.reminder.repository;

import com.example.reminder.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    @Query("SELECT c FROM Categoria c WHERE c.user.userId = :userId")
    public List<Categoria> getCategoriesByUserId(@Param("userId") Integer userId);
}
