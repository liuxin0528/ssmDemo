package com.zongheng.ssm.dao;

import com.zongheng.ssm.mapping.*;

public interface TdMStaffDao {
	
    int deleteByPrimaryKey(String staffId);

    int insert(TdMStaff record);

    int insertSelective(TdMStaff record);

    TdMStaff selectByPrimaryKey(String staffId);

    int updateByPrimaryKeySelective(TdMStaff record);

    int updateByPrimaryKey(TdMStaff record);
}