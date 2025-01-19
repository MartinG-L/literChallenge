package com.example.literchallenge.literchallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
        Integer count,
        List<DatosLibro> results
) {
}
