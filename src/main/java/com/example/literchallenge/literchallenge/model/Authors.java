package com.example.literchallenge.literchallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Authors(
        String name,
        Integer birth_year,
        Integer death_year
) {
}
