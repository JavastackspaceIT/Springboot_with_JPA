package com.appointment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointment.model.Book;

public interface BookStoreRepository extends JpaRepository<Book, Integer> {


}
