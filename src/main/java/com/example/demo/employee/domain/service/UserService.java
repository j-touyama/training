package com.example.demo.employee.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employee.domain.form.UserForm;
import com.example.demo.employee.domain.model.User;
import com.example.demo.employee.domain.repository.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	/** 部署ごとのユーザー一覧を検索 */
	public List<User> selectedDpt(String deptCd) throws Exception {
		List<User> list = new ArrayList<>();
		list = dao.selectedDpt(deptCd);
		return list;
	}

	/** 全ユーザーを検索 */
	public List<User> selectAll() throws Exception {
		List<User> list = new ArrayList<>();
		list = dao.selectAll();
		return list;
	}
	/** idからユーザーを検索 */
	public User selectedId(String id) throws Exception{
		User list = new User();
		list = dao.selectedId(id);
		return list;
	}
	/** ユーザー情報を登録 */
	public boolean insertUser(UserForm form) throws Exception{
		int resultNum = dao.insertUser(form);
		return resultNum > 0 ? true : false;
	}
	/** ユーザー情報を更新 */
	public boolean updateUser(UserForm form) throws Exception{
		int resultNum = dao.updateUser(form);
		return resultNum > 0 ? true : false;
	}
	/** ユーザー情報を削除 */
	public boolean deleteUser(int id) throws Exception{
		int resultNum = dao.deleteUser(id);
		return resultNum > 0 ? true : false;
	}
}
