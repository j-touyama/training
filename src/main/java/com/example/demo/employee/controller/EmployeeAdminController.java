package com.example.demo.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.employee.domain.form.UserForm;
import com.example.demo.employee.domain.model.User;
import com.example.demo.employee.domain.service.UserService;

@Controller
@RequestMapping(value="/employee/admin")
public class EmployeeAdminController {

	@Autowired
	private UserService service;

	/**
	 * 社員情報管理画面初期表示処理
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index", method={RequestMethod.GET, RequestMethod.POST})
	public String index(Model model) {
		try {
			// 画面初期表示処理
			initDisplay(model);
			return "/admin/index";
		} catch (Exception e) {
			e.printStackTrace();
			return "employee";
		}
	}

	/**
	 * 戻るボタン押下時の処理
	 * @return
	 */
	@RequestMapping(value="/edit", params="back", method=RequestMethod.POST)
	public String backPage() {
		return "redirect:/employee";
	}

	/**
	 * 新規登録ボタン押下時の処理
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/edit", params="insert", method={RequestMethod.POST, RequestMethod.GET})
	public String insert(@ModelAttribute("form") UserForm form, Model model) {
		model.addAttribute("form", new User());
		return "/admin/insert";
	}

	/**
	 * 更新ボタン押下時の処理
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/edit", params="update", method={RequestMethod.POST, RequestMethod.GET})
	public String update(@ModelAttribute("form") UserForm form, Model model) {
		try {
			// idに紐づくユーザー情報取得
			getUserInfo(model, form.getId());

			return "/admin/update";
		} catch (Exception e) {
			e.printStackTrace();
			return "employee/admin";
		}
	}

	/**
	 * 削除ボタン押下時の処理
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/edit", params="delete", method={RequestMethod.POST, RequestMethod.GET})
	public String delete(@RequestParam("id") String id, Model model) {
		try {
			// idに紐づくユーザー情報取得
			getUserInfo(model, id);

			return "/admin/delete";
		} catch (Exception e) {
			e.printStackTrace();
			return "admin";
		}
	}

	/**
	 * URLを直叩きした時の処理
	 * @return
	 */
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String getMapping() {
		return "redirect:/employee";
	}

	/**
	 * 初期処理
	 * @param model
	 * @throws Exception
	 */
	private void initDisplay(Model model) throws Exception {
		List<User> list = new ArrayList<>();
		// 社員一覧取得
		list = service.selectAll();
		model.addAttribute("members", list);
	}

	/**
	 * ユーザー情報を取得する。
	 * @param model
	 * @param id
	 * @throws Exception
	 */
	private void getUserInfo(Model model, String id) throws Exception {
		// idに紐づく社員情報を取得
		User user = service.selectedId(id);
		String projectType = user.getProjectType();
		// <br>要素は改行コードに変換してテキストエリアに表示する。
		if(projectType != null && !projectType.isEmpty())
			user.setProjectType(projectType.replaceAll("<br>", "\r\n"));

		model.addAttribute("form", user);
	}
}
