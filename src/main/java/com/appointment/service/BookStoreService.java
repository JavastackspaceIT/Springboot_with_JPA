
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

		Author author = new Author();
		author.setName(bookForm.getBookName());
		author.setQualification(bookForm.getQualification());

		Book book = new Book();
		book.setBookName("java book");
		book.setTitile("java developer group");
		book.setAuthor(author);

		bookStoreRepository.save(book);
		return 1;
	}
}
