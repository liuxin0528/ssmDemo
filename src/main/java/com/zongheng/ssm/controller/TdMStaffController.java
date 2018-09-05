/**
 * 
 */
package com.zongheng.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zongheng.ssm.base.domain.TdMStaff;
import com.zongheng.ssm.service.ItdMStaffService;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/staff")
public class TdMStaffController {
	
	@Autowired
	private ItdMStaffService itdMStaffService;

	@RequestMapping("/queryStaff")
	public String queryStaff(){
		System.out.println("���뵽��controller��");
		
		TdMStaff staff = itdMStaffService.getStaffById("000077");
		
		System.out.println("000077�ŵ��������ǣ�" + staff.getStaffName());
		
		return "staff";
	}
}
