package com.example.tuit_university_crud_app.Entitys;

import com.example.tuit_university_crud_app.Entitys.Template.AbsEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address extends AbsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long address_id;

    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String region;
    @Column(nullable = false)
    private String district;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false,unique = true)
    private Long raqam;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    // JsonBackReference needed to prevent infinite recursion.
    @JsonBackReference
    private Student student;
}
