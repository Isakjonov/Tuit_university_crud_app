package com.example.tuit_university_crud_app.Services;

import com.example.tuit_university_crud_app.payload.ApiResponse;
import com.example.tuit_university_crud_app.payload.ReqStudent;
import com.example.tuit_university_crud_app.payload.ResPageable;
import com.example.tuit_university_crud_app.payload.ResStudent;
import org.springframework.http.HttpEntity;

import java.util.List;

public interface StudentServiceInterface {
    public ResPageable getAllStudent(int page, int size);
    public ApiResponse createStudent(ReqStudent reqStudent);
    public HttpEntity<?> getStudent(Long student_id);

    //get all
    public List<ResStudent> getAllStudents();

    //put
    public HttpEntity<?> editStudent(ReqStudent reqStudent);

    //delete
    public HttpEntity<?> deleteStudent(Long student_id);
}
