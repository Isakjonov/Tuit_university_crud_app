package com.example.tuit_university_crud_app.Entitys;

import com.example.tuit_university_crud_app.Entitys.Template.AbsEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends AbsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long student_id;

    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private Integer age;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Address> addressList;

}
