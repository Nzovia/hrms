package com.smartmax.hrms.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Center {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique =true,length = 50)
	private String name;
	private boolean enabled =true;
	@OneToMany(cascade= CascadeType.MERGE,fetch= FetchType.EAGER)
	@JoinColumn(name="center_id")
	private List<Employee>employees;
	public Center(int id, String name,List<Employee>employees) {
		super();
		this.id = id;
		this.name = name;
		this.enabled = true;
		this.employees = employees;
	}
	public Center() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<Employee>getEmployees(){
		return employees;
	}
	public void  setEmployees(List<Employee>employees) {
		this.employees = employees;
	}
	public void addEmployee(Employee employee){
		this.employees.add(employee);
	}
	

}
