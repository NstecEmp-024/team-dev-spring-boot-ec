package com.fullness.ec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    private Integer empId; // 従業員ID
    private Integer accountId; // アカウントID
    private String password; // パスワード
}
