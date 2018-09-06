package com.zongheng.ssm.serviceImpl;

import com.zongheng.ssm.base.persistence.TdMStaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.zongheng.ssm.base.domain.TdMStaff;
import com.zongheng.ssm.service.ItdMStaffService;

@Service
public class TdMStaffServiceImpl implements ItdMStaffService{

	@Autowired
	private TdMStaffMapper tdMStaffMapper;

	@Override
	public TdMStaff getStaffById(String staffId) {
		System.out.println("");
		TdMStaff staff = tdMStaffMapper.selectByPrimaryKey(staffId);
		return staff;
	}
}
