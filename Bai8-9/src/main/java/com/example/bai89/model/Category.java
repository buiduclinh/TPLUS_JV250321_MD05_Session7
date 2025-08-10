package com.example.bai89.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
    private int id;
    private String categoryName;
    @NotBlank(message = "Can not Bank this!")
    private String description;
    private boolean status;
}
