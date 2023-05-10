package com.example.tuit_university_crud_app.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqAddress {
    private Long address_id;
    private String country;
    private String region;
    private String district;
    private String street;
    private Long raqam;
    private Long parentId;

}
