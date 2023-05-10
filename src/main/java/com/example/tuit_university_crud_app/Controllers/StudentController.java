package com.example.tuit_university_crud_app.Controllers;

import com.example.tuit_university_crud_app.Services.StudentService;
import com.example.tuit_university_crud_app.payload.ReqStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/s-post")
    public HttpEntity<?> createStudent(@RequestBody ReqStudent reqStudent) {
        return ResponseEntity.ok().body(studentService.createStudent(reqStudent));
    }
    @GetMapping("/s-allget-p-s")
    public HttpEntity<?> getAllCategory(
            @RequestParam(value = "page",defaultValue = "10") int page,
            @RequestParam(value = "size",defaultValue = "10") int size){
            return ResponseEntity.ok().body(studentService.getAllStudent(page,size));
    }
    @GetMapping("/s-allget")
    public HttpEntity<?> getAllStudents() {
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }

    @GetMapping("/s-oneget/{student_id}")
    public HttpEntity<?> getStudent(@PathVariable Long student_id) {
        return studentService.getStudent(student_id);
    }

    @PutMapping("/s-put")
    public HttpEntity<?> editStudent(@RequestBody ReqStudent reqStudent) {
        return studentService.editStudent(reqStudent);
    }

    @DeleteMapping("/s-delete/{student_id}")
    public HttpEntity<?> deleteStudent(@PathVariable Long student_id) {
        return studentService.deleteStudent(student_id);
    }
}
