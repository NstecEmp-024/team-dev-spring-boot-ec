package com.fullness.ec.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fullness.ec.entity.Account;

@Mapper
public interface EmployeeRepository {
    
    List<Account> selectByEmployeeName();
}
