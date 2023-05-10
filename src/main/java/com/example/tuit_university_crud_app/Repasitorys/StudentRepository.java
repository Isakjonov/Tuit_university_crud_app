package com.example.tuit_university_crud_app.Repasitorys;

import com.example.tuit_university_crud_app.Entitys.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
