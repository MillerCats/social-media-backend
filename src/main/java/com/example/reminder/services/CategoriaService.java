package com.example.reminder.services;

import com.example.reminder.models.Categoria;
import com.example.reminder.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> getCategoriesByUser(Integer userId) {
        return categoriaRepository.getCategoriesByUserId(userId);
    }

    public Categoria createCategory(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria updateCategory(Integer categoryId, Categoria categoria) {
        Categoria foundCategory = categoriaRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("No se encontró id de esta categoria."));
        foundCategory.setCategoryName(categoria.getCategoryName());
        foundCategory.setCategoryDesc(categoria.getCategoryDesc());
        foundCategory.setCategoryImg(categoria.getCategoryImg());
        return categoriaRepository.save(foundCategory);
    }
}
