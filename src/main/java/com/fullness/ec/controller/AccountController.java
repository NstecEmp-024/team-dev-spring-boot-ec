package com.fullness.ec.controller;

import java.util.List;
import com.fullness.ec.service.AccountService;
import com.fullness.ec.service.AccountServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fullness.ec.entity.Account;
import com.fullness.ec.entity.AccountRole;
import com.fullness.ec.entity.Employee;
import com.fullness.ec.form.AccountForm;
import com.fullness.ec.repository.EmployeeAccountRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
@RequestMapping("admin/account")
public class AccountController {
    private final AccountService accountService;
    private final EmployeeAccountRepository accountRepository;

    public AccountController(EmployeeAccountRepository accountRepository,
            AccountService accountService) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
    }

    @ModelAttribute("accountForm")
    public AccountForm setupForm() {
        return new AccountForm();
    }

    @GetMapping("/form")
    public String form(Model model) {
        List<Employee> unregisteredEmployees = accountRepository.selectUnregisteredEmployeeNames();
        model.addAttribute("unregisteredEmployees", unregisteredEmployees); // HTMLに渡す
        return "admin/account/form";
    }

    @PostMapping("/confirm")
    public String confirm(@ModelAttribute("accountForm") AccountForm accountForm, Model model) {
        Integer empId = accountForm.getEmpId();
        Employee employee = accountService.findById(empId);
        if (employee != null) {
            accountForm.setEmployeeName(employee.getName());
        }
        model.addAttribute("accountForm", accountForm);
        return "admin/account/confirm";
    }

    @PostMapping("/complete")
    public String complete(@ModelAttribute("accountForm") AccountForm accountForm) {
        // パスワードをハッシュ化する（BCrypt使用）
        String encodedPassword = new BCryptPasswordEncoder().encode(accountForm.getPassword());
        Account account = new Account(
                accountForm.getEmpId(),
                accountForm.getAccountName(),
                encodedPassword);
        accountService.addAccount(account);
        return "/admin/account/complete";
    }

    @GetMapping("/complete")
    public String complete() {
        return "admin/account/complete";
    }

    @GetMapping("/menu")
    public String menu() {
        return "/admin/menu";
    }

}