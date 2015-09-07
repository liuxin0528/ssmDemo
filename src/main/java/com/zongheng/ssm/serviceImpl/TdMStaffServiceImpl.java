package com.zongheng.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zongheng.ssm.dao.TdMStaffDao;
import com.zongheng.ssm.mapping.TdMStaff;
import com.zongheng.ssm.service.ItdMStaffService;

@Service
public class TdMStaffServiceImpl implements ItdMStaffService{
	
	@Autowired
	private TdMStaffDao tdMStaffDao;

	@Override
	public TdMStaff getStaffById(String staffId) {
		System.out.println("进入到TdMStaffServiceImpl中查询数据。。。。。。");
		TdMStaff staff = tdMStaffDao.selectByPrimaryKey(staffId);
		return staff;
	}

	

}
