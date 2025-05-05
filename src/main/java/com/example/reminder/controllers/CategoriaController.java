package com.example.reminder.controllers;

import com.example.reminder.models.Categoria;
import com.example.reminder.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/categoriesByUser/{userId}")
    public ResponseEntity<Object> getCategoriesByUser(@PathVariable Integer userId) {
        List<Categoria> categories = categoriaService.getCategoriesByUser(userId);
        if (!categories.isEmpty()) {
            return ResponseEntity.ok(categories);
        } else {
            return ResponseEntity.ofNullable("Empty");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createCategory(@RequestBody Categoria categoria) {
        try {
            byte[] imageBytes = Base64.getDecoder().decode(categoria.getCategoryImg());
            Categoria categoriaValues =  new Categoria();
            categoriaValues.setUser(categoria.getUser());
            categoriaValues.setCategoryName(categoria.getCategoryName());
            categoriaValues.setCategoryDesc(categoria.getCategoryDesc());
            categoriaValues.setCategoryImg(imageBytes);
            Categoria createdCategory = categoriaService.createCategory(categoriaValues);
            return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear: " + e, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("updateCategory/{categoryId}")
    public ResponseEntity<Object> updateCategory(@PathVariable Integer categoryId, @RequestBody Categoria categoria) {
        try {
            Categoria updatedCategory = categoriaService.updateCategory(categoryId, categoria);
            return ResponseEntity.ok(updatedCategory);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar: " + e);
        }
    }
}
