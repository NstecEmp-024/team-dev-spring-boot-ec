package com.fullness.ec.service;

import com.fullness.ec.entity.Account;
import com.fullness.ec.entity.Employee;
import com.fullness.ec.entity.ProductCategory;
import com.fullness.ec.repository.AccountRepository;
import com.fullness.ec.repository.EmployeeAccountRepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
public class AccountServiceTest {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private EmployeeAccountRepository employeeRepository;

    @Test
    public void testAddAccount() {
        Account account = new Account();
        account.setName("testuser");
        account.setPassword("password");
        account.setEmployeeId(1); // 既存の従業員IDを設定

        accountService.addAccount(account);    
    }

    @Test
    public void testFindById() {
        Employee employee = accountService.findById(1);

        assertNotNull(employee);
        assertEquals(1, employee.getId());
        assertEquals("高橋太郎", employee.getName());
        assertTrue(true);
    }
}
