package com.example.tuit_university_crud_app.payload;

import com.example.tuit_university_crud_app.Entitys.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResAddress {
    private Long address_id;
    private String country;
    private String region;
    private String district;
    private String street;
    private Long raqam;
    private Long parentId;

    public ResAddress(Long address_id, String country, String region, String district, String street, Long raqam) {
        this.address_id = address_id;
        this.country = country;
        this.region = region;
        this.district = district;
        this.street = street;
        this.raqam = raqam;
    }

    public ResAddress(Address address){
        this.address_id=address.getAddress_id();
        this.country= address.getCountry();
        this.region= address.getRegion();
        this.district= address.getDistrict();
        this.street= address.getStreet();
        this.raqam=address.getRaqam();
        this.parentId=address.getStudent().getStudent_id();
    }

}
