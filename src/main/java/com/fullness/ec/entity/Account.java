package com.fullness.ec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    private  Integer empid;//従業員ID
    private String accountName; //名前
    private String password; //パスワード
    private AccountRole role;//権限
}
