package com.example.demo.employee.domain.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.example.demo.employee.domain.model.ValidGroup1;
import com.example.demo.employee.domain.model.ValidGroup2;
import com.example.demo.employee.domain.model.ValidGroup3;

public class UserForm {

	private String id;
	@NotEmpty(groups={ValidGroup1.class},message="社員コードを入力してください。")
	@Pattern(regexp = "^[0-9]*$", groups={ValidGroup2.class},message="数値で入力してください。")
	@Length(max=4, groups={ValidGroup3.class},message="4文字以下で入力してください。")
	private String staff_code;
	@NotEmpty(groups={ValidGroup1.class},message="姓を入力してください。")
	private String last_name;
	@NotEmpty(groups={ValidGroup1.class},message="名を入力してください。")
	private String first_name;
	@NotEmpty(groups={ValidGroup1.class},message="姓(ローマ字)を入力してください。")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", groups={ValidGroup2.class},message="半角英数字で入力してください。")
	private String last_name_romaji;
	@NotEmpty(groups={ValidGroup1.class},message="名(ローマ字)を入力してください。")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", groups={ValidGroup2.class},message="半角英数字で入力してください。")
	private String first_name_romaji;
	private String staff_photo_url;
	@NotEmpty(groups={ValidGroup1.class},message="部署コードを入力してください。")
	@Pattern(regexp = "^[0-9]*$", groups={ValidGroup2.class},message="数値で入力してください。")
	@Range(max=4, groups={ValidGroup3.class},message="4文字以下で入力してください。")
	private String staff_department;
	private String staff_attribute;
	private String project_type;
	@NotEmpty(groups={ValidGroup1.class}, message="日付を入力してください。")
	@Pattern(regexp = "^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$", groups={ValidGroup2.class},message="yyyy/MM/dd形式で入力してください。")
	private String joined_year;
	@NotEmpty(groups={ValidGroup1.class},message="経歴を選択してください。")
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
	public String getJoined_year() {
		return joined_year;
	}
	public void setJoined_year(String joined_year) {
		this.joined_year = joined_year;
	}
	public String getCarrer_type() {
		return carrer_type;
	}
	public void setCarrer_type(String carrer_type) {
		this.carrer_type = carrer_type;
	}
}
