
package com.appointment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.dao.BookStoreRepository;
import com.appointment.dao.UserRepository;
import com.appointment.form.BookForm;
import com.appointment.model.Author;
import com.appointment.model.Book;

@Service
public class BookStoreService {

	@Autowired
	private BookStoreRepository bookStoreRepository;

	public int registerBook(BookForm bookForm) {

		Book bookObj = new Book();
        bookObj.setTitle(bookForm.getTitle());
        bookObj.setDescription(bookForm.getDescription());

        bookObj.setAuthor(new Author(bookForm.getName(), bookForm.getTitle()));

        // Persisting (Or Saving) The Book Entity To The Database

		bookStoreRepository.save(bookObj);
		return 1;
	}
}
