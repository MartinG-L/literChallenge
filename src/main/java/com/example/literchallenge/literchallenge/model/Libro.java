package com.example.literchallenge.literchallenge.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String title;
    private Integer download_count;
    private String languages;
    @ManyToOne
    private Autor autor;

    public  Libro(){};

    public Libro(DatosLibro libro) {
        this.title = libro.title();
        this.download_count = libro.download_count();
        this.languages = libro.languages();
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDownload_count() {
        return download_count;
    }

    public void setDownload_count(Integer download_count) {
        this.download_count = download_count;
    }

    @Override
    public String toString() {
        return  "Titulo: " + title +
                " | Autor: " + autor.getAutor() +
                " | Lenguaje: " + languages +
                " | Descargas: " + download_count;
    }
}
