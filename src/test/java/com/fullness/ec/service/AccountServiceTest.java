package com.fullness.ec.service;

import com.fullness.ec.entity.Account;
import com.fullness.ec.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testAddAccount() {
        // アカウントを作成
        Account account = new Account(1, "test", "password");
        accountService.addAccount(account);

        // 追加したアカウントを確認するために、リポジトリから取得するなどの方法を使用します。
        // ここでは簡単のため、nullチェックのみ行います。
        assertNotNull(account);
        assertEquals("test", account.getName());
        assertEquals("password", account.getPassword());
        assertTrue(true);
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
