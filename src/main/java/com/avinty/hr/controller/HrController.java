package com.avinty.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.avinty.hr.service.IHrService;

@RestController
@RequestMapping(path = "/API/V1/employees")
public class HrController {
	@Autowired
	IHrService service;

	@GetMapping("/hello")
	public @ResponseBody String hello() {
		return service.hello();
	}

	/*
	 * @PostMapping("/dostuff") public void doStuff() { service.doStuff(); }
	 */
}
