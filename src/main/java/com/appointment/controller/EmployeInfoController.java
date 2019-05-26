package com.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.form.EmployeeInfoForm;
import com.appointment.response.BookResponse;
import com.appointment.service.EmployeeInfoService;

@RestController
public class EmployeInfoController {

	@Autowired
	private EmployeeInfoService employeeInfoService;

	@PostMapping("/insertEmployeeInfo")
	public ResponseEntity<BookResponse> insertEmployeeInfo(@RequestBody EmployeeInfoForm employeeInfoForm) {

		employeeInfoService.insertEmployee(employeeInfoForm);
		BookResponse bookResponse = new BookResponse(HttpStatus.CREATED.value(), "resource has created");
		return new ResponseEntity<BookResponse>(bookResponse, HttpStatus.ACCEPTED);
	}
}
