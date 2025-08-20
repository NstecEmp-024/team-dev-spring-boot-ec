package com.fullness.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fullness.ec.entity.Account;
import com.fullness.ec.repository.EmployeeRepository;

@Service
@Transactional
public class ManageResistServiceImpl implements ManageResistService {
    @Autowired
    private EmployeeRepository employeeRepository; // 従業員リポジトリ

    @Override
    public void addAccount(Account account) {
        employeeRepository.insertAccount(account); // アカウント登録
    }
}