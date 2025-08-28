package com.fullness.ec.service;

import org.springframework.stereotype.Service;

import com.fullness.ec.entity.Account;

@Service
public interface AccountService {
    void addAccount(Account account);

}