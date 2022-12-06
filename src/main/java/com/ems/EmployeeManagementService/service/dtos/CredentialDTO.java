package com.ems.EmployeeManagementService.service.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class CredentialDTO implements Serializable {

    private String userName;
    private String password;

}
