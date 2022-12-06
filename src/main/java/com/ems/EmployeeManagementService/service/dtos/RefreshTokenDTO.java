package com.ems.EmployeeManagementService.service.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class RefreshTokenDTO implements Serializable {


    private String refreshToken;
}
