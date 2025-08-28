package com.fullness.ec.service;

import org.springframework.stereotype.Service;

import com.fullness.ec.entity.Account;
import com.fullness.ec.entity.Employee;

@Service
public interface AccountService {
    void addAccount(Account account);

    Employee findById(Integer empId);
}