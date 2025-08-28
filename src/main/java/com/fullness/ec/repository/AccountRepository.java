package com.fullness.ec.repository;

import org.apache.ibatis.annotations.Mapper;

import com.fullness.ec.entity.Account;

@Mapper
public interface AccountRepository {
    void insertAccount(Account account); // アカウント登録

    void insert(Account account);

    Account selectByUserName(String username);
    // @Param("username") String username

    Account selectById(String accountName); // IDでアカウントを取得

}