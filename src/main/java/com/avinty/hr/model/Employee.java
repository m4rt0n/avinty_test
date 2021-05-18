package com.avinty.hr.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 255)
	private String email;

	@Column(length = 66)
	private String password;

	@Column(name = "full_name", length = 200)
	private String fullName;

	// ???
	@Column(name = "dep_id")
	private long depId;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "createdBy")
	private long createdBy;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "updated_by")
	private long updatedBy;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_department", joinColumns = @JoinColumn(name = "manager_id", referencedColumnName = "dep_id"), inverseJoinColumns = @JoinColumn(name = "dep_id", referencedColumnName = "manager_id"))
	private List<Department> departments = new ArrayList<>();

	public void addDepartment(Department dept) {
		departments.add(dept);
	}
}
