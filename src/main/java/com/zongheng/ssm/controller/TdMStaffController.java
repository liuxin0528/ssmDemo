/**
 * 
 */
package com.zongheng.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zongheng.ssm.mapping.TdMStaff;
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
		System.out.println("进入到了controller中");
		
		TdMStaff staff = itdMStaffService.getStaffById("000077");
		
		System.out.println("000077号的人姓名是：" + staff.getStaffName());
		
		return "staff";
	}
}
