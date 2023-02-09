package com.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.persistence.BookDao;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Override
	public Book searchBookByBookId(int bookId) {
		try {
			return bookDao.findBookByBookId(bookId);
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public Book searchBookByBookGenre(String bookGenre) {
		try {
			return bookDao.findBookByBookGenre(bookGenre);
		} catch (Exception ex) {
			return null;
		}
	}

}
