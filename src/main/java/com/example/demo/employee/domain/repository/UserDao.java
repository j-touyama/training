package com.example.demo.employee.domain.repository;

import java.util.List;

import com.example.demo.employee.domain.form.UserForm;
import com.example.demo.employee.domain.model.User;

public interface UserDao {

	/** 全ユーザーを検索 */
	public List<User> selectAll() throws Exception;
	/** 部署ごとのユーザー一覧を検索 */
	public List<User> selectedDpt(String deptCd) throws Exception;
	/** idからユーザーを検索 */
	public User selectedId(String id) throws Exception;
	/** ユーザー情報を登録 */
	public int insertUser(UserForm form) throws Exception;
	/** ユーザー情報を更新 */
	public int updateUser(UserForm form) throws Exception;
	/** ユーザー情報を削除 */
	public int deleteUser(int id) throws Exception;
}
