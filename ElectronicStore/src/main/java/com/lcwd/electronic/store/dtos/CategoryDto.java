package com.lcwd.electronic.store.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private String categoryId;

    @NotBlank(message = "Title is required")
    @Size(min = 4, message = "Title must be at least 4 characters long")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Cover image is required")
    private String coverImage;
}
