package com.example.demo.employee.domain.model;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class User {

	private long id;
	private String staff_code;
	private String last_name;
	private String first_name;
	private String last_name_romaji;
	private String first_name_romaji;
	private String staff_department;
	private String project_type;
	private String joined_year;
	private boolean new_glad_flg=true;
	private Map<String, String> departmentMap = new LinkedHashMap<>();
	
package com.example.demo.employee.domain.model;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class User {

	private long id;
	private String staffCode;
	private String lastName;
	private String firstName;
	private String lastNameRomaji;
	private String firstNameRomaji;
	private String staffDepartment;
	private String projectType;
	private String joinedYear;
	private boolean newGladFlg = true;
	private Map<String, String> departmentMap = new LinkedHashMap<>();
	
	public User() {
		departmentMap.put("0001", "エンジニア");
		departmentMap.put("0002", "営業");
		departmentMap.put("0003", "コーポレート");
	}

	public Map<String, String> getDepartmentMap() {
		return departmentMap;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
