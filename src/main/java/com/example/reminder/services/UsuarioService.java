package com.example.reminder.services;

import com.example.reminder.models.Usuario;
import com.example.reminder.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario loginUser(Usuario usuario) {
        return usuarioRepository.loginUser(usuario.getUserName(), usuario.getUserPass());
    }

    public Usuario getUserById(Integer userId) {
        return usuarioRepository.findById(userId).orElseThrow(() -> new RuntimeException("No se encontró id de este usuario."));
    }

    public Usuario signUpUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUser(Integer userId, Usuario usuario) {
        Usuario foundUser = usuarioRepository.findById(userId).orElseThrow(() -> new RuntimeException("Id del usuario no encontrado"));
        foundUser.setUserName(usuario.getUserName());
        foundUser.setUserLastName(usuario.getUserLastName());
        foundUser.setUserPass(usuario.getUserPass());
        foundUser.setUserEmail(usuario.getUserEmail());
        foundUser.setUserHandle(usuario.getUserHandle());
        foundUser.setUserBorn(usuario.getUserBorn());
        return usuarioRepository.save(foundUser);
    }
}
