package com.dibyendu.learning.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SignUpRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String sex;
    private String phone;
    private String address;
    private String dob;
}
