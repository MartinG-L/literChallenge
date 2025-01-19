package com.example.literchallenge.literchallenge.repository;

import com.example.literchallenge.literchallenge.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findByAutor(String autor);

    @Query("SELECT a FROM Autor a WHERE a.birth_day <= :year AND (a.death_day IS NULL OR a.death_day >= :year)")
    List<Autor> findAuthorsAliveInYear(Integer year);
}
