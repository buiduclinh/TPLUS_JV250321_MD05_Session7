package com.example.ex.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {
    private int id;
    @NotBlank
    private String title;
    private String director;
    private LocalDate releaseDate;
    private String genre;
    private String poster;
}
