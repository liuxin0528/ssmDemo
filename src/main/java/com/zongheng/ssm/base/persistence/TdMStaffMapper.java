package com.zongheng.ssm.base.persistence;

import com.zongheng.ssm.base.domain.TdMStaff;

public interface TdMStaffMapper {
	
    int deleteByPrimaryKey(String staffId);

    int insert(TdMStaff record);

    int insertSelective(TdMStaff record);

    TdMStaff selectByPrimaryKey(String staffId);

    int updateByPrimaryKeySelective(TdMStaff record);

    int updateByPrimaryKey(TdMStaff record);
}