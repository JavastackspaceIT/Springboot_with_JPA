package com.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.form.BookForm;
import com.appointment.response.BookResponse;
import com.appointment.service.BookStoreService;

@RestController
public class BookStoreController {

	@Autowired
	private BookStoreService bookStoreService;

	@PostMapping(value = "/registerBook")
	public ResponseEntity<BookResponse> registerBook(@RequestBody BookForm bookForm) {

		System.out.println("bookForm " + bookForm);
		bookStoreService.registerBook(bookForm);
		BookResponse bookResponse = new BookResponse(HttpStatus.CREATED.value(), "resource has created");
		return new ResponseEntity<BookResponse>(bookResponse, HttpStatus.ACCEPTED);

	}
}
