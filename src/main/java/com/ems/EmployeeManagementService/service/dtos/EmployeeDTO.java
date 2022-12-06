package com.ems.EmployeeManagementService.service.dtos;

import com.ems.EmployeeManagementService.entites.Department;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

@Setter
@Getter
public class EmployeeDTO implements Serializable {

    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private Department department;
}
