package com.example.demo.employee.domain.form;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.example.demo.employee.domain.model.ValidGroup1;
import com.example.demo.employee.domain.model.ValidGroup2;
import com.example.demo.employee.domain.model.ValidGroup3;

public class UserForm {

	private String id;
	@NotEmpty(groups={ValidGroup1.class},message="社員コードを入力してください。")
	@Pattern(regexp = "^[0-9]*$", groups={ValidGroup2.class},message="社員コードは半角数値で入力してください。")
	@Length(min=4, max=4, groups={ValidGroup3.class},message="社員コードは4文字で入力してください。")
	private String staffCode;
	@NotEmpty(groups={ValidGroup1.class},message="姓を入力してください。")
	@Length(max=20, groups={ValidGroup2.class},message="姓は20文字以下で入力して下さい。")
	private String lastName;
	@NotEmpty(groups={ValidGroup1.class},message="名を入力してください。")
	@Length(max=20, groups={ValidGroup2.class},message="名は20文字以下で入力して下さい。")
	private String firstName;
	@NotEmpty(groups={ValidGroup1.class},message="姓_ローマ字を入力してください。")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", groups={ValidGroup2.class},message="姓_ローマ字は半角英数字で入力して下さい。")
	@Length(max=40, groups={ValidGroup2.class},message="姓_ローマ字は40文字以下で入力して下さい。")
	private String lastNameRomaji;
	@NotEmpty(groups={ValidGroup1.class},message="名_ローマ字を入力してください。")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", groups={ValidGroup2.class},message="名_ローマ字は半角英数字で入力して下さい。")
	@Length(max=40, groups={ValidGroup2.class},message="名_ローマ字は40文字以下で入力して下さい。")
	private String firstNameRomaji;
	@NotEmpty(groups={ValidGroup1.class},message="所属を選択して下さい。")
	@Length(max=100, groups={ValidGroup1.class},message="案件は100文字以下で入力して下さい。")
	private String staffDepartment;
	private String projectType;
	@NotEmpty(groups={ValidGroup1.class}, message="入社年を入力して下さい。")
	@Pattern(regexp = "^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$", groups={ValidGroup2.class},message="入社年は「yyyy/MM/dd」の形式で入力して下さい。")
	private String joinedYear;
	private boolean newGladFlg=true;

	private Map<String, String> departmentMap = new LinkedHashMap<>();
	
	public UserForm() {
		departmentMap.put("0001", "エンジニア");
		departmentMap.put("0002", "営業");
		departmentMap.put("0003", "コーポレート");
	}

	public Map<String, String> getDepartmentMap() {
		return departmentMap;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNameRomaji() {
		return lastNameRomaji;
	}

	public void setLastNameRomaji(String lastNameRomaji) {
		this.lastNameRomaji = lastNameRomaji;
	}

	public String getFirstNameRomaji() {
		return firstNameRomaji;
	}

	public void setFirstNameRomaji(String firstNameRomaji) {
		this.firstNameRomaji = firstNameRomaji;
	}

	public String getStaffDepartment() {
		return staffDepartment;
	}

	public void setStaffDepartment(String staffDepartment) {
		this.staffDepartment = staffDepartment;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getJoinedYear() {
		return joinedYear;
	}

	public void setJoinedYear(String joinedYear) {
		this.joinedYear = joinedYear;
	}

	public boolean isNewGladFlg() {
		return newGladFlg;
	}

	public void setNewGladFlg(boolean newGladFlg) {
		this.newGladFlg = newGladFlg;
	}

	public void setDepartmentMap(Map<String, String> departmentMap) {
		this.departmentMap = departmentMap;
	}

}
