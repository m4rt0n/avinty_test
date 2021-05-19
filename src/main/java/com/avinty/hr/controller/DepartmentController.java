package com.avinty.hr.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avinty.hr.model.Department;
import com.avinty.hr.model.DepartmentNotFoundException;
import com.avinty.hr.model.EmployeeNotFoundException;
import com.avinty.hr.service.DepartmentService;

@RestController
@RequestMapping(path = "/API/V1/departments")
public class DepartmentController {
	@Autowired
	DepartmentService dService;

	@GetMapping
	public List<Department> getAllDepartments() {
		return dService.getAllDepartments();
	}

	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable("id") long id)
			throws EmployeeNotFoundException, DepartmentNotFoundException {
		return dService.getDepartmentbyId(id);
	}

	@PostMapping
	public Department createDepartment(@RequestParam(value = "name") String name,
			@RequestParam(value = "createdAt") Timestamp createdAt, @RequestParam(value = "createdBy") long createdBy,
			@RequestParam(value = "updatedAt") Timestamp updatedAt, @RequestParam(value = "updatedBy") long updatedBy) {
		return dService.saveDepartment(name, createdAt, createdBy, updatedAt, updatedBy);
	}

	@PutMapping("/{id}")
	public Department updateDepartmentById(@PathVariable("id") long id, @RequestParam(value = "name") String name,
			@RequestParam(value = "createdAt") Timestamp createdAt, @RequestParam(value = "createdBy") long createdBy,
			@RequestParam(value = "updatedAt") Timestamp updatedAt, @RequestParam(value = "updatedBy") long updatedBy)
			throws EmployeeNotFoundException, DepartmentNotFoundException {
		return dService.updateDepartment(id, name, createdAt, createdBy, updatedAt, updatedBy);
	}

	@DeleteMapping("/{id}")
	public void deleteDepartmentById(@PathVariable("id") long id) {
		dService.deleteDepartment(id);
	}
}
