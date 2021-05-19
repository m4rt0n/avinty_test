package com.avinty.hr.model;

import java.time.LocalDateTime;
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
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends CustomTimeStamps {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 255)
	private String email;

	@Column(length = 66)
	private String password;

	@Column(name = "full_name", length = 200)
	private String fullName;

	@NotNull(message = "depId cannot be null")
	@Column(name = "dep_id")
	private long depId;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "createdBy")
	private long createdBy;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "updated_by")
	private long updatedBy;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_department", joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "dep_id", referencedColumnName = "id"))
	private List<Department> departments = new ArrayList<>();

	public void addDepartment(Department dept) {
		departments.add(dept);
	}

	// ----------------------------------------------
	public Employee() {
	}

	public Employee(String email, String password, String fullName, long createdBy, long updatedBy) {
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public long getDepId() {
		return depId;
	}

	public void setDepId(long depId) {
		this.depId = depId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
}
