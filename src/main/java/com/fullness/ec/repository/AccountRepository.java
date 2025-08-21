package com.fullness.ec.repository;

import org.apache.ibatis.annotations.Mapper;

import com.fullness.ec.entity.Account;

@Mapper
public interface  AccountRepository {
    void insert(Account account);

    Account selectByUserName(String username);

}
