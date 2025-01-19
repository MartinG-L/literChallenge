package com.example.literchallenge.literchallenge.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        String title,
        List<Authors> authors,
        Integer download_count,
        String languages
) {
    @JsonCreator
    public DatosLibro(
            @JsonProperty("title") String title,
            @JsonProperty("authors") List<Authors> authors,
            @JsonProperty("download_count") Integer download_count,
            @JsonProperty("languages") JsonNode languagesNode
    ) {
        this(title, authors, download_count,
                (languagesNode != null && languagesNode.isArray() && !languagesNode.isEmpty())
                        ? languagesNode.get(0).asText()
                        : null
        );
    }
}


