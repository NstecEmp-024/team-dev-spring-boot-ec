package com.fullness.ec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    // private  Integer empId;//従業員ID
    private Integer employeeId;
    // private String empName; //名前
    private String name;
    private String password; //パスワード
    private AccountRole role;//権限
}
