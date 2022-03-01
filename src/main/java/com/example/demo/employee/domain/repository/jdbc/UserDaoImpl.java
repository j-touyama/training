package com.example.demo.employee.domain.repository.jdbc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.example.demo.employee.domain.form.UserForm;
import com.example.demo.employee.domain.model.User;
import com.example.demo.employee.domain.repository.UserDao;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final String USER_NAME = "user";

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
		Timestamp nowTime = getNowTime();
		String projectType = form.getProjectType();
		// 改行コードは<br>要素に変換して登録する。
		if(projectType != null && !projectType.isEmpty())
			projectType = projectType.replaceAll("\r\n", "<br>");

		String sql = "INSERT INTO staffs (staff_code, last_name, first_name, last_name_romaji, first_name_romaji,"
				+ " staff_department, project_type, joined_year, new_glad_flg, created_by, updated_by, created_at, updated_at)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(sql,
				form.getStaffCode(),
				form.getLastName(),
				form.getFirstName(),
				form.getLastNameRomaji(),
				form.getFirstNameRomaji(),
				form.getStaffDepartment(),
				projectType,
				form.getJoinedYear(),
				form.isNewGladFlg(),
				USER_NAME,
				USER_NAME,
				nowTime,
				nowTime
				);
		return result;
	}

	@Override
	public int updateUser(UserForm form) throws Exception {
		Timestamp nowTime = getNowTime();
		String projectType = form.getProjectType();
		// 改行コードは<br>要素に変換して登録する。
		if(projectType != null && !projectType.isEmpty())
			projectType = projectType.replaceAll("\r\n", "<br>");
		String sql = "UPDATE staffs SET staff_code = ?, last_name = ?, first_name = ?,"
				+ " last_name_romaji = ?, first_name_romaji = ?, staff_department = ?,"
				+ " project_type = ?, joined_year = ?, new_glad_flg = ?,"
				+ " updated_by = ?, updated_at = ?"
				+ " WHERE id = ?";
		int result = jdbcTemplate.update(sql,
				form.getStaffCode(),
				form.getLastName(),
				form.getFirstName(),
				form.getLastNameRomaji(),
				form.getFirstNameRomaji(),
				form.getStaffDepartment(),
				projectType,
				form.getJoinedYear(),
				form.isNewGladFlg(),
				USER_NAME,
				nowTime,
				form.getId()
				);
		return result;
	}

	@Override
	public int deleteUser(String staffCode) throws Exception {
		String sql = "DELETE FROM staffs WHERE staff_code = ?";
		int result = jdbcTemplate.update(sql, staffCode);
		return result;
	}
	
	private User setUserInfo(Map<String, Object> map) {

		User user = new User();
		user.setId((long)map.get("id"));
		user.setStaffCode((String)map.get("staff_code"));
		user.setLastName((String)map.get("last_name"));
		user.setFirstName((String)map.get("first_name"));
		user.setLastNameRomaji((String)map.get("last_name_romaji"));
		user.setFirstNameRomaji((String)map.get("first_name_romaji"));
		user.setStaffDepartment((String)map.get("staff_department"));
		String projectType = (String)map.get("project_type");
		if(StringUtils.isEmpty(projectType))
			projectType = "ー";
		user.setProjectType(projectType);
		user.setJoinedYear((String)map.get("joined_year"));
		user.setNewGladFlg((boolean) map.get("new_glad_flg"));

		return user;
	}
	private Timestamp getNowTime() {
		long millis = System.currentTimeMillis();
	    Timestamp timestamp = new Timestamp(millis);
		return timestamp;
	}

}
