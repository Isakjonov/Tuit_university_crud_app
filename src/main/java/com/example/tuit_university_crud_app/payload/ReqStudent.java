package com.example.tuit_university_crud_app.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqStudent {
    private Long student_id;
    private String first_name;
    private String last_name;
    private String email;
    private Integer age;

}
