package com.fullness.ec.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.fullness.ec.entity.Account;
import com.fullness.ec.entity.AccountRole;
import com.fullness.ec.entity.Employee;

@Mapper
public interface EmployeeAccountRepository {
    // アカウント名でAccountを1件取得
    Account selectByUserName(@Param("accountName") String accountName);

    // アカウント未登録の従業員名一覧を取得
    List<Employee> selectUnregisteredEmployeeNames();

    void insertAccount(Account account); // アカウント登録

    Employee findById(Integer empId);
}
