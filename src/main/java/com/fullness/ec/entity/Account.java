package com.fullness.ec.entity;

import javax.management.relation.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    private Integer id;
    private Integer employeeId;
    private String name;
    private String password;
    //private Role role;

    public Account(Integer empId, String accountName, String password) {
        this.employeeId = Integer.valueOf(empId);
        this.name = accountName;
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}