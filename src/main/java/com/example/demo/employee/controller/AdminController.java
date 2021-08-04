package com.example.demo.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.employee.domain.form.UserForm;
import com.example.demo.employee.domain.model.User;
import com.example.demo.employee.domain.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private UserService service;
	
	@GetMapping("admin")
	public String getAdmin(Model model) {
		// 画面初期表示処理
		initDisplay(model);
	
		return "/admin/index";
	}

	@PostMapping("admin")
	public String postAdmin(Model model) {
		List<User> list = new ArrayList<>();
		try {
			list = service.selectAll();
			model.addAttribute("members", list);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return "/admin/index";
	}

	@PostMapping(value="admin/edit", params="back")
	public String backPage(Model model) {
		return "redirect:/employee";
	}

	@PostMapping(value="admin/edit", params="insert")
	public String postAdminInsert(@ModelAttribute("form") UserForm form, Model model) {

		return "/admin/insert";
	}

	@PostMapping(value="admin/edit", params="update")
	public String postAdminUpdate(@RequestParam("id") String id, Model model) {
		try {
			model.addAttribute("form", service.selectedId(id));
			return "/admin/update";
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return "admin";
		}
	}

	@PostMapping(value="admin/edit", params="delete")
	public String postAdminDelete(@RequestParam("id") String id, Model model) {
		try {
			model.addAttribute("form", service.selectedId(id));
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return "/admin/delete";
	}
	private void initDisplay(Model model) {
		List<User> list = new ArrayList<>();
		try {
			list = service.selectAll();
			model.addAttribute("members", list);
		} catch (Exception e) {
			// TODO エラー画面作成して飛ばしたい。
			e.printStackTrace();
		}
	}

}
