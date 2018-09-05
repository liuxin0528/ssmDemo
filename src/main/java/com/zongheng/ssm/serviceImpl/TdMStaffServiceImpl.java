package com.zongheng.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zongheng.ssm.dao.TdMStaffDao;
import com.zongheng.ssm.base.domain.TdMStaff;
import com.zongheng.ssm.service.ItdMStaffService;

@Service
public class TdMStaffServiceImpl implements ItdMStaffService{
	
	@Autowired
	private TdMStaffDao tdMStaffDao;

	@Override
	public TdMStaff getStaffById(String staffId) {
		System.out.println("���뵽TdMStaffServiceImpl�в�ѯ���ݡ�����������");
		TdMStaff staff = tdMStaffDao.selectByPrimaryKey(staffId);
		return staff;
	}

	

}
