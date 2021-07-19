package com.example.demo.employee.domain.repository.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.employee.domain.form.UserForm;
import com.example.demo.employee.domain.model.User;
import com.example.demo.employee.domain.repository.UserDao;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<User> selectedDpt(String deptCd) {

		String sql = "SELECT * FROM staffs WHERE staff_department = ?";

		List<User> result = new ArrayList<>();
		User user = new User();

		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, deptCd);
		for (Map<String, Object> map : list) {
			user = setUserInfo(map);
			result.add(user);
		}

		return result;
	}

	@Override
	public List<User> selectAll() throws Exception {
		String sql = "SELECT * FROM staffs";

		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		List<User> result = new ArrayList<>();
		User user = new User();

		for (Map<String, Object> map : list) {
			user = setUserInfo(map);
			result.add(user);
		}
		
		return result;
	}

	@Override
	public User selectedId(String id) throws Exception {
		String sql = "SELECT * FROM staffs WHERE id = ?";

		Map<String, Object> map = jdbcTemplate.queryForMap(sql, id);

		return setUserInfo(map);
	}

	@Override
	public int insertUser(UserForm form) throws Exception {
		String sql = 
				"INSERT INTO staffs (staff_code, last_name, first_name, last_name_romaji, first_name_romaji,"
				+ " staff_department, staff_attribute, project_type, joined_year, carrer_type)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(sql,
				form.getStaff_code(),
				form.getLast_name(),
				form.getFirst_name(),
				form.getLast_name_romaji(),
				form.getFirst_name_romaji(),
				form.getStaff_department(),
				form.getStaff_attribute(),
				form.getProject_type(),
				form.getJoined_year(),
				form.getCarrer_type()
				);
		return result;
	}

	@Override
	public int updateUser(UserForm form) throws Exception {
		String sql = "UPDATE staffs SET staff_code = ?, last_name = ?, first_name = ?,"
				+ " last_name_romaji = ?, first_name_romaji = ?, staff_department = ?,"
				+ " staff_attribute = ?, project_type = ?, joined_year = ?, carrer_type = ?"
				+ " WHERE id = ?";
		int result = jdbcTemplate.update(sql,
				form.getStaff_code(),
				form.getLast_name(),
				form.getFirst_name(),
				form.getLast_name_romaji(),
				form.getFirst_name_romaji(),
				form.getStaff_department(),
				form.getStaff_attribute(),
				form.getProject_type(),
				form.getJoined_year(),
				form.getCarrer_type(),
				form.getId()
				);
		return result;
	}

	@Override
	public int deleteUser(int id) throws Exception {
		String sql = "DELETE FROM staffs WHERE id = ?";
		int result = jdbcTemplate.update(sql, id);
		return result;
	}
	
	private User setUserInfo(Map<String, Object> map) {

		User user = new User();
		user.setId((long)map.get("id"));
		user.setStaff_code((String)map.get("staff_code"));
		user.setLast_name((String)map.get("last_name"));
		user.setFirst_name((String)map.get("first_name"));
		user.setLast_name_romaji((String)map.get("last_name_romaji"));
		user.setFirst_name_romaji((String)map.get("first_name_romaji"));
		user.setStaff_photo_url((String)map.get("staff_photo_url"));
		user.setStaff_department((String)map.get("staff_department"));
		user.setStaff_attribute((String)map.get("staff_attribute"));
		user.setProject_type((String)map.get("project_type"));
		user.setJoined_year((Date)map.get("joined_year"));
		user.setCarrer_type((String)map.get("carrer_type"));
		return user;
	}

}
