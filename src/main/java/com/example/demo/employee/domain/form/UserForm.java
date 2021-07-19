package com.example.demo.employee.domain.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserForm {

	private String id;
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

	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public void setJoined_year(String joined_year) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = dateFormat.parse(joined_year);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			this.joined_year = null;
		}
		this.joined_year = date;
	}
	public String getCarrer_type() {
		return carrer_type;
	}
	public void setCarrer_type(String carrer_type) {
		this.carrer_type = carrer_type;
	}
}