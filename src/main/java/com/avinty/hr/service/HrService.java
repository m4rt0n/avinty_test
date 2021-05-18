package com.avinty.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avinty.hr.data.DepartmentRepo;
import com.avinty.hr.data.EmployeeRepo;

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
	public void doStuff() {
		/*
		 * @Override public void doStuff() { // one owner many pet Owner o1 = new
		 * Owner("o1"); Pet p1 = new Pet("p1"); Pet p2 = new Pet("p2");
		 * 
		 * // List<Pet> pets = new ArrayList<>(); // o1.setPets(pets);
		 * 
		 * o1.addPet(p1); o1.addPet(p2); ownerRepo.save(o1);
		 * 
		 * // one pet many owners Owner o2 = new Owner("o2"); Owner o3 = new
		 * Owner("o3"); Pet p3 = new Pet("p3"); o2.addPet(p3); o3.addPet(p3);
		 * ownerRepo.save(o2); ownerRepo.save(o3); }
		 */

	}

}
