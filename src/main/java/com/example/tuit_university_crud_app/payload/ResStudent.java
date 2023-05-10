package com.example.tuit_university_crud_app.payload;

import com.example.tuit_university_crud_app.Entitys.Address;
import com.example.tuit_university_crud_app.Entitys.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResStudent {
    private Long student_id;
    private String first_name;
    private String last_name;
    private Integer age;
    private List<Address> addressList;
    public ResStudent(Student student) {
        this.student_id=student.getStudent_id();
        this.first_name=student.getFirst_name();
        this.last_name=student.getLast_name();
        this.age=student.getAge();
        this.addressList=student.getAddressList();
    }

}
