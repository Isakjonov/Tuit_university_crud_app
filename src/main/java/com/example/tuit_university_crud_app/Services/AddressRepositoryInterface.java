package com.example.tuit_university_crud_app.Services;

import com.example.tuit_university_crud_app.payload.*;
import org.springframework.http.HttpEntity;

import java.util.List;

public interface AddressRepositoryInterface {
    public ResPageable getAllAddress(int page, int size);
    public ApiResponse createAddress(ReqAddress reqAddress);
    public HttpEntity<?> getAddress(Long address_id);

    //get all
    public List<ResAddress> getAllAddresses();

    //put
    public HttpEntity<?> editAddress(ReqAddress reqAddress);

    //delete
    public HttpEntity<?> deleteAddress(Long address_id);
}
