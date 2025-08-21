package com.fullness.ec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    private  Integer id;//ユーザーID
    private String username; //ユーザー名
    private String name; //名前
    private String password; //パスワード
    private AccountRole role;//権限
}
