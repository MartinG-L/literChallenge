package com.example.literchallenge.literchallenge.repository;

import com.example.literchallenge.literchallenge.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    Libro findByTitle(String title);
    List<Libro> findByLanguages(String languages);
}
