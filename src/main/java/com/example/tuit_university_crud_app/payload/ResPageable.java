package com.example.tuit_university_crud_app.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResPageable {
    private List<?> data;
    private long totalElements;
    private int totalPages;
}
