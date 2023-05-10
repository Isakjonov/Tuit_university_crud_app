package com.example.tuit_university_crud_app.Controllers;

import com.example.tuit_university_crud_app.Services.AddressService;
import com.example.tuit_university_crud_app.payload.ReqAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/a-post")
    public HttpEntity<?> createAddress(@RequestBody ReqAddress reqAddress) {
        return ResponseEntity.ok().body(addressService.createAddress(reqAddress));
    }
    @GetMapping("/a-allget-p-s")
    public HttpEntity<?> getAllAddress(
            @RequestParam(value = "page",defaultValue = "10") int page,
            @RequestParam(value = "size",defaultValue = "10") int size){
        return ResponseEntity.ok().body(addressService.getAllAddress(page,size));
    }
    @GetMapping("/a-allget")
    public HttpEntity<?> getAllAddress() {
        return ResponseEntity.ok().body(addressService.getAllAddresses());
    }

    @GetMapping("/a-oneget/{address_id}")
    public HttpEntity<?> getAddress(@PathVariable Long address_id) {
        return addressService.getAddress(address_id);
    }

    @PutMapping("/a-put")
    public HttpEntity<?> editAddress(@RequestBody ReqAddress reqAddress) {
        return addressService.editAddress(reqAddress);
    }

    @DeleteMapping("/a-delete/{address_id}")
    public HttpEntity<?> deleteAddress(@PathVariable Long address_id) {
        return addressService.deleteAddress(address_id);
    }
}
