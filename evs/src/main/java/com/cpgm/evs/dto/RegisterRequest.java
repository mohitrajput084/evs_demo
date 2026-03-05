package com.cpgm.evs.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    private String name;
    private String mobile;
    private String password;
    private String district;
}