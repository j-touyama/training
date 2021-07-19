package com.example.demo.employee.domain.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserList {
	
	private List<User> engineer;
	private List<User> sales;
	private List<User> corporate;

	public List<User> getEngineer() {
		return engineer;
	}
	public void setEngineer(List<User> engineer) {
		this.engineer = engineer;
	}
	public List<User> getSales() {
		return sales;
	}
	public void setSales(List<User> sales) {
		this.sales = sales;
	}
	public List<User> getCorporate() {
		return corporate;
	}
	public void setCorporate(List<User> corporate) {
		this.corporate = corporate;
	}
}
