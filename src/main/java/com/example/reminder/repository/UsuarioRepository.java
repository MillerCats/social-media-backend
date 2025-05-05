package com.example.reminder.repository;

import com.example.reminder.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u WHERE u.userName = :name AND u.userPass = :pass")
    Usuario loginUser(@Param("name") String name, @Param("pass") String pass);
}
