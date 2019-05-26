package com.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.exception.UserException;
import com.appointment.model.StudentForm;
import com.appointment.model.User;
import com.appointment.response.Response;
import com.appointment.service.UserService;

/**
 * @author Rakesh
 *
 */
/**
 * @author Rakesh
 *
 */
/**
 * @author Rakesh
 *
 */
@RestController
@RequestMapping("/spring-data-jpa")
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping("/getUsers")
	public List<User> getAllUsers() {
		return service.getUsers();
	}

	@GetMapping("/getUserByProfession/{profession}")
	public List<User> getUserByProfession(@PathVariable String profession) {
		return service.getUserByProfession(profession);
	}

	@GetMapping("/getUserCount/{age}")
	public String getCountByAge(@PathVariable int age) {
		long count = service.getCounts(age);
		return "total no of records : " + count;
	}

	@DeleteMapping("/delete/{name}")
	public List<User> deleteUser(@PathVariable String name) {

		return service.deleteUser(name);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Response> deleteUser(@PathVariable Integer id) throws UserException {
		int status = 0;
		status = service.deleteUser(id);
		if (status != 0) {
			Response response = new Response(HttpStatus.OK.value(), "Requested Resource has deleted");
			return new ResponseEntity<Response>(response, HttpStatus.CREATED);
		} else {
			Response response = new Response(HttpStatus.NO_CONTENT.value(), "Not Content foud.");
			return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/findMultiCondition/{profession}/{age}")
	public List<User> getUsersByProfessionAndAge(@PathVariable String profession, @PathVariable int age) {
		return service.findByMultiCondition(profession, age);
	}

	@GetMapping("/getUsersIgnoreCase")
	public List<User> getUsersByprofession(@RequestParam("profession") String profession) {
		return service.getUsersIgnoreCase(profession);
	}

	@GetMapping("/getSort/{field}")
	public List<User> getSortedUsers(@PathVariable String field) {
		return service.getUserSort(field);
	}

	@GetMapping("/getPaginatedData")
	public Page<User> getPaginatedRecords() {
		return service.getPaginatedUser();
	}

	@GetMapping("/getRecordsByCustomQuery")
	public List<User> getUsersByCustomQuery() {
		return service.getUsersCustomQuery();
	}

	@PostMapping("/student")
	public ResponseEntity<Response> insertStudent(@RequestBody StudentForm studentDto) throws UserException {

		int i = service.createStudent(studentDto);
		System.out.println(studentDto);
		if (i != 0) {
			Response response = new Response(HttpStatus.CREATED.value(), "resource has created");
			return new ResponseEntity<Response>(response, HttpStatus.CREATED);
		} else {
			Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "resource has created");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/update")
	public ResponseEntity<Response> updateStudent(@RequestBody StudentForm studentDto) throws UserException {

		int i = service.updateStudent(studentDto);
		System.out.println(studentDto);
		if (i != 0) {
			Response response = new Response(HttpStatus.CREATED.value(), "resource has created");
			return new ResponseEntity<Response>(response, HttpStatus.CREATED);
		} else {
			Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "resource has created");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
 
 
}
