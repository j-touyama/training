package com.example.demo.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.employee.domain.model.UserList;
import com.example.demo.employee.domain.service.UserService;

@Controller
public class EmployeeController {
	
	@Autowired
	private UserService service;

	@RequestMapping(value="employee", method=RequestMethod.GET)
	public String index(Model model) {
		// 画面初期表示処理
		initDisplay(model);
		return "/employee/index";
	}

	private void initDisplay(Model model) {
		UserList list = new UserList();
		try {
			// エンジニアの一覧を取得。
			list.setEngineer(service.selectedDpt("0001"));
			// 営業担当の一覧を取得。
			list.setSales(service.selectedDpt("0002"));
			// コーポレートの一覧を取得。
			list.setCorporate(service.selectedDpt("0003"));
			model.addAttribute("member", list);
		} catch (Exception e) {
			// TODO エラー画面作成して飛ばしたい。
			e.printStackTrace();
		}
	}
}
