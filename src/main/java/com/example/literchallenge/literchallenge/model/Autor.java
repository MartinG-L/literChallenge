package com.example.literchallenge.literchallenge.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true, nullable = false)
    private String autor;
    private Integer birth_day;
    private Integer death_day;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> librosList;

    public Autor(){};

    public Autor(Authors a) {
        this.autor = a.name();
        this.birth_day = a.birth_year();
        this.death_day = a.death_year();
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(Integer birth_day) {
        this.birth_day = birth_day;
    }

    public Integer getDeath_day() {
        return death_day;
    }

    public void setDeath_day(Integer death_day) {
        this.death_day = death_day;
    }

    public List<Libro> getLibrosList() {
        return librosList;
    }

    public void setLibrosList(List<Libro> librosList) {
        this.librosList = librosList;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Autor: " + autor +
                " | Fecha de nacimiento: " + birth_day +
                " | Fecha de fallecimiento: " + death_day;
    }
}
