package com.fullness.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fullness.ec.entity.Account;
import com.fullness.ec.repository.AccountRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void addAccount(Account account) {
    //     String hashed = passwordEncoder.encode(account.getPassword());
    // account.setPassword(hashed); // ハッシュ化されたパスワードをセット
    accountRepository.insert(account); // DBに保存
    // System.out.println("ハッシュ化されたパスワード: " + hashed); // ターミナルに表示

    }

    }


