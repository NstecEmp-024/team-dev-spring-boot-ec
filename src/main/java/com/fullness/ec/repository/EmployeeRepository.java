package com.fullness.ec.repository;

import org.apache.ibatis.annotations.Mapper;

import com.fullness.ec.entity.Account;

@Mapper
public interface EmployeeRepository {
    void insertAccount(Account account); // アカウント登録
}
