package com.fullness.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fullness.ec.entity.Account;
import com.fullness.ec.entity.Employee;
import com.fullness.ec.repository.AccountRepository;
import com.fullness.ec.repository.EmployeeAccountRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository; // アカウントリポジトリのインジェクション

    @Override
    public void addAccount(Account account) {
        accountRepository.insert(account); // アカウントをデータベースに追加するメソッドを呼び出す
    }

    @Autowired
    private EmployeeAccountRepository employeeAccountRepository;

    @Override
    public Employee findById(Integer empId) {
        return employeeAccountRepository.findById(empId);
    }
}
