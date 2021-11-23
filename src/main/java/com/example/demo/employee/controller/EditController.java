package com.example.demo.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.employee.domain.form.UserForm;
import com.example.demo.employee.domain.model.GroupOrder;
import com.example.demo.employee.domain.service.UserService;

@Controller
@RequestMapping(value="employee/admin/edit")
public class EditController {

	@Autowired
	private UserService service;

	private static final String INSERT = "登録"; 
	private static final String UPDATE = "更新"; 
	private static final String DELETE = "削除"; 

	@RequestMapping(value="/insert", params="regist", method=RequestMethod.POST)
	public String insertRegist(@ModelAttribute("form") @Validated(GroupOrder.class) UserForm form,
			BindingResult result, Model model) throws Exception {
		try {
			if (result.hasErrors()) {
				return "admin/insert";
			}
			service.insertUser(form);
			model.addAttribute("editType", INSERT);
			return "/admin/result";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/index";
		}
	}

	@RequestMapping(value="/update", params="regist", method=RequestMethod.POST)
	public String updateRegist(@ModelAttribute("form") @Validated(GroupOrder.class) UserForm form,
			BindingResult result, Model model) {
		try {
			if (result.hasErrors()) {
				return "admin/update";
			}
			service.updateUser(form);
			model.addAttribute("editType", UPDATE);
			return "/admin/result";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/index";
		}

	}

	@RequestMapping(value="/delete", params="regist", method=RequestMethod.POST)
	public String deleteRegist(@ModelAttribute("form") @Validated(GroupOrder.class) UserForm form,
			BindingResult result, Model model) {
		try {
			service.deleteUser(form.getStaff_code());
			model.addAttribute("editType", DELETE);
			return "/admin/result";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/index";
		}
	}

	@RequestMapping(value={"/insert", "/update", "/delete"}, params="back", method=RequestMethod.POST)
	public String back() {
		return "redirect:/employee/admin/index";
	}
}
