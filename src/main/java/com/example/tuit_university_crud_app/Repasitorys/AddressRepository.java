package com.example.tuit_university_crud_app.Repasitorys;

import com.example.tuit_university_crud_app.Entitys.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
