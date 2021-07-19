package com.example.demo.employee.domain.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class User {

	private long id;
	private String staff_code;
	private String last_name;
	private String first_name;
	private String last_name_romaji;
	private String first_name_romaji;
	private String staff_photo_url;
	private String staff_department;
	private String staff_attribute;
	private String project_type;
	private Date joined_year;
	private String carrer_type;
	private String login_id;
	private String login_pw;
	private boolean login_flg;
	private String auth_code;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStaff_code() {
		return staff_code;
	}
	public void setStaff_code(String staff_code) {
		this.staff_code = staff_code;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name_romaji() {
		return last_name_romaji;
	}
	public void setLast_name_romaji(String last_name_romaji) {
		this.last_name_romaji = last_name_romaji;
	}
	public String getFirst_name_romaji() {
		return first_name_romaji;
	}
	public void setFirst_name_romaji(String first_name_romaji) {
		this.first_name_romaji = first_name_romaji;
	}
	public String getStaff_photo_url() {
		return staff_photo_url;
	}
	public void setStaff_photo_url(String staff_photo_url) {
		this.staff_photo_url = staff_photo_url;
	}
	public String getStaff_department() {
		return staff_department;
	}
	public void setStaff_department(String staff_department) {
		this.staff_department = staff_department;
	}
	public String getStaff_attribute() {
		return staff_attribute;
	}
	public void setStaff_attribute(String staff_attribute) {
		this.staff_attribute = staff_attribute;
	}
	public String getProject_type() {
		return project_type;
	}
	public void setProject_type(String project_type) {
		this.project_type = project_type;
	}
	public Date getJoined_year() {
		return joined_year;
	}
	public void setJoined_year(Date joined_year) {
		this.joined_year = joined_year;
	}
	public String getCarrer_type() {
		return carrer_type;
	}
	public void setCarrer_type(String carrer_type) {
		this.carrer_type = carrer_type;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getLogin_pw() {
		return login_pw;
	}
	public void setLogin_pw(String login_pw) {
		this.login_pw = login_pw;
	}
	public boolean isLogin_flg() {
		return login_flg;
	}
	public void setLogin_flg(boolean login_flg) {
		this.login_flg = login_flg;
	}
	public String getAuth_code() {
		return auth_code;
	}
	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}

}
