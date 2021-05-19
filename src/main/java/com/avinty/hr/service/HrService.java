package com.avinty.hr.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avinty.hr.data.DepartmentRepo;
import com.avinty.hr.data.EmployeeRepo;
import com.avinty.hr.model.Department;
import com.avinty.hr.model.Employee;

@Service
public class HrService implements IHrService {
	@Autowired
	EmployeeRepo eRepo;
	@Autowired
	DepartmentRepo dRepo;

	@Override
	public String hello() {
		return "Hello";

	}

	@Override
	public void addEntities() {
		Timestamp ts = Timestamp.valueOf(LocalDateTime.now());

		// one dept many emps

		Employee e1 = new Employee("e1@mail.com", "e1pw", "e1fname", ts, 1, ts, 1);
		// Employee e2 = new Employee("e2@mail.com", "e2pw", "e2fname", ts, 1, ts, 1);
		Department d1 = new Department("d1name", ts, 1, ts, 1);
//		Department d2 = new Department("d2name", ts, 1, ts, 1);

		// !!! id generated at repo save !!!
		// System.out.println(String.format("e1id: %s, d1id: %s", e1.getId(),
		// d1.getId()));
		e1.setDepId(d1.getId());
		d1.setManagerId(e1.getId());
		// d1.setEmployees(Arrays.asList(e1, e2));
		dRepo.save(d1);
		eRepo.save(e1);
		// eRepo.save(e2);

		Employee xe1 = eRepo.findByfullName("e1fname");
		System.out.println("e1id from query: " + xe1.getId());

		Department xd1 = dRepo.findByname("d1name");
		System.out.println("d1id: " + xd1.getId());
		/*
		 * // one emp many depts Employee e1 = new Employee("e1@mail.com", "e1pw",
		 * "e1fname", ts, 1, ts, 1); // Employee e2 = new Employee("e2@mail.com",
		 * "e2pw", "e2fname", ts, 1, ts, 1); Department d1 = new Department("d1name",
		 * ts, 1, ts, 1); Department d2 = new Department("d2name", ts, 1, ts, 1);
		 * e1.setDepartments(Arrays.asList(d1, d2));
		 */
	}

}
