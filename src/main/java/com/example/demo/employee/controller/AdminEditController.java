package com.example.demo.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.employee.domain.form.UserForm;
import com.example.demo.employee.domain.service.UserService;

@Controller
public class AdminEditController {

	@Autowired
	private UserService service;

	@GetMapping("admin/edit")
	public String getAdmin() {

		return "redirect:/admin";
	}

	@PostMapping(value="admin/edit/insert", params="regist")
	public String postAdminInsertRegist(UserForm form, Model model) {
		try {
			service.insertUser(form);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return "forward:/admin";
	}

	@PostMapping(value="admin/edit/update", params="regist")
	public String postAdminUpdateRegist(UserForm form, Model model) {
		try {
			service.updateUser(form);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return "forward:/admin";
	}

	@PostMapping(value="admin/edit/delete", params="regist")
	public String postAdminDeleteRegist(int id, Model model) {
		try {
			service.deleteUser(id);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return "forward:/admin";
	}

	@PostMapping(value={"admin/edit/insert", "admin/edit/update", "admin/edit/delete"}, params="back")
	public String back() {

		return "redirect:/admin";
	}
}
