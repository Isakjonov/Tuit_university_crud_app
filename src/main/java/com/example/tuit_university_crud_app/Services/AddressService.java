package com.example.tuit_university_crud_app.Services;

import com.example.tuit_university_crud_app.Entitys.Address;
import com.example.tuit_university_crud_app.Entitys.Student;
import com.example.tuit_university_crud_app.Repasitorys.AddressRepository;
import com.example.tuit_university_crud_app.Repasitorys.StudentRepository;
import com.example.tuit_university_crud_app.payload.ApiResponse;
import com.example.tuit_university_crud_app.payload.ReqAddress;
import com.example.tuit_university_crud_app.payload.ResAddress;
import com.example.tuit_university_crud_app.payload.ResPageable;
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
public class AddressService implements AddressRepositoryInterface{
    private final AddressRepository addressRepository;
    private final StudentRepository studentRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository, StudentRepository studentRepository) {
        this.addressRepository = addressRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public ResPageable getAllAddress(int page, int size) {
        Page<Address> all = addressRepository.findAll(PageRequest.of(page, size));
        ResPageable resPageable = new ResPageable();
        Page<ResAddress> map = all.map(ResAddress::new);
        resPageable.setData(map.getContent());
        resPageable.setTotalPages(map.getTotalPages());
        resPageable.setTotalElements(map.getTotalElements());
        return resPageable;
    }

    @Override
    public ApiResponse createAddress(ReqAddress reqAddress) {
        try {
            Address address =new Address();
            address.setAddress_id(reqAddress.getAddress_id());
            address.setCountry(reqAddress.getCountry());
            address.setRegion(reqAddress.getRegion());
            address.setDistrict(reqAddress.getDistrict());
            address.setStreet(reqAddress.getStreet());
            address.setRaqam(reqAddress.getRaqam());
            if (reqAddress.getParentId()!=null){
                Optional<Student> byId = studentRepository.findById(reqAddress.getParentId());
                if (byId.isPresent()){
                    address.setStudent(byId.get());
                }
            }
            addressRepository.save(address);
            return new ApiResponse("Address malumotlari saqlandi",true);
        }catch (Exception exception){
            return new ApiResponse("Malumotni qayta kiriting ozgartiring nimadr hato",false);
        }
    }
    @Override
    public HttpEntity<?> getAddress(Long address_id) {
        Optional<Address> byId = addressRepository.findById(address_id);
        if (byId.isPresent()) {
            return ResponseEntity.ok().body(new ResAddress(byId.get()));
        } else {
            return ResponseEntity.ok().body("address_id not found");
        }
    }
    @Override
    public List<ResAddress> getAllAddresses() {
        return addressRepository.findAll().stream().map(ResAddress::new).collect(Collectors.toList());
    }

    @Override
    public HttpEntity<?> editAddress(ReqAddress reqAddress) {
        Optional<Address> byId = addressRepository.findById(reqAddress.getAddress_id());
        if (byId.isPresent()) {
            Address address = byId.get();
            address.setAddress_id(reqAddress.getAddress_id());
            address.setCountry(reqAddress.getCountry());
            address.setRegion(reqAddress.getRegion());
            address.setDistrict(reqAddress.getDistrict());
            address.setStreet(reqAddress.getStreet());
            address.setRaqam(reqAddress.getRaqam());
            Address saved = addressRepository.save(address);
            return ResponseEntity.ok().body(new ResAddress(saved));
        } else {
            return ResponseEntity.status(400).body("address_id not found");
        }
    }

    @Override
    public HttpEntity<?> deleteAddress(Long address_id) {
        Optional<Address> byId = addressRepository.findById(address_id);
        if (byId.isPresent()) {
            addressRepository.delete(byId.get());
            return ResponseEntity.ok().body("O'chirildi");
        } else {
            return ResponseEntity.status(400).body("address_id not found");
        }
    }
}
