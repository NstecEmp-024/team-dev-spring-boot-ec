package com.fullness.ec.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fullness.ec.entity.AccountRoll;

@Mapper
public interface ManageResistRepository {
    List<AccountRoll> selectByEmployee();
}
