package com.example.tuit_university_crud_app.Services;

import com.example.tuit_university_crud_app.Entitys.Student;
import com.example.tuit_university_crud_app.Repasitorys.AddressRepository;
import com.example.tuit_university_crud_app.Repasitorys.StudentRepository;
import com.example.tuit_university_crud_app.payload.ApiResponse;
import com.example.tuit_university_crud_app.payload.ReqStudent;
import com.example.tuit_university_crud_app.payload.ResPageable;
import com.example.tuit_university_crud_app.payload.ResStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService implements StudentServiceInterface{
    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }


    @Override
    public ResPageable getAllStudent(int page, int size) {
        Page<Student> all = studentRepository.findAll(PageRequest.of(page, size));
        ResPageable resPageable = new ResPageable();
        Page<ResStudent> map = all.map(ResStudent::new);
        resPageable.setData(map.getContent());
        resPageable.setTotalPages(map.getTotalPages());
        resPageable.setTotalElements(map.getTotalElements());
        return resPageable;
    }

    @Override
    public ApiResponse createStudent(ReqStudent reqStudent) {
        try{
            Student student = new Student();
            student.setStudent_id(reqStudent.getStudent_id());
            student.setFirst_name(reqStudent.getFirst_name());
            student.setLast_name(reqStudent.getLast_name());
            student.setEmail(reqStudent.getEmail());
            student.setAge(reqStudent.getAge());
            studentRepository.save(student);
            return new ApiResponse("Student malumotlari saqlandi",true);
        }catch (Exception exception){
            return new ApiResponse("Kechirasiz qayta urinib ko'ring",false);
        }

    }

    @Override
    public HttpEntity<?> getStudent(Long student_id) {
        Optional<Student> byId = studentRepository.findById(student_id);
        if (byId.isPresent()) {
            return ResponseEntity.ok().body(new ResStudent(byId.get()));
        } else {
            return ResponseEntity.ok().body("student_id not found");
        }
    }

    @Override
    public List<ResStudent> getAllStudents() {
        return studentRepository.findAll().stream().map(ResStudent::new).collect(Collectors.toList());
    }

    @Override
    public HttpEntity<?> editStudent(ReqStudent reqStudent) {
        Optional<Student> byId = studentRepository.findById(reqStudent.getStudent_id());
        if (byId.isPresent()) {
            Student student = byId.get();
            student.setFirst_name(reqStudent.getFirst_name());
            student.setLast_name(reqStudent.getLast_name());
            student.setEmail(reqStudent.getEmail());
            student.setAge(reqStudent.getAge());
            Student saved = studentRepository.save(student);
            return ResponseEntity.ok().body(new ResStudent(saved));
        } else {
            return ResponseEntity.status(400).body("student_id not found");
        }
    }

    @Override
    public HttpEntity<?> deleteStudent(Long student_id) {
        Optional<Student> byId = studentRepository.findById(student_id);
        if (byId.isPresent()) {
            studentRepository.delete(byId.get());
            return ResponseEntity.ok().body("O'chirildi");
        } else {
            return ResponseEntity.status(400).body("student_id not found");
        }
    }

}
