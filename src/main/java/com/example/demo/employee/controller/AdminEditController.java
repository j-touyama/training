package com.example.demo.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.employee.domain.form.UserForm;
import com.example.demo.employee.domain.model.GroupOrder;
import com.example.demo.employee.domain.service.UserService;

@Controller
public class AdminEditController {

	@Autowired
	private UserService service;

	@PostMapping(value="admin/edit/insert", params="regist")
	public String postAdminInsertRegist(@ModelAttribute("form") @Validated(GroupOrder.class) UserForm form,
			BindingResult result, Model model) {
		try {
			if (result.hasErrors()) {
				return "admin/insert";
			}
			service.insertUser(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin/result";
	}

	@PostMapping(value="admin/edit/update", params="regist")
	public String postAdminUpdateRegist(@ModelAttribute("form") @Validated(GroupOrder.class) UserForm form,
			BindingResult result, Model model) {
		try {
			if (result.hasErrors()) {
				return "admin/update";
			}
			service.updateUser(form);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return "/admin/result";
	}

	@PostMapping(value="admin/edit/delete", params="regist")
	public String postAdminDeleteRegist(int id, Model model) {
		try {
			service.deleteUser(id);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return "/admin/result";
	}

	@PostMapping(value={"admin/edit/insert", "admin/edit/update", "admin/edit/delete"}, params="back")
	public String back() {

		return "redirect:/admin";
	}
}
