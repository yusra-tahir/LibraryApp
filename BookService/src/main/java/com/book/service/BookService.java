package com.book.service;

import com.book.entity.Book;

public interface BookService {
	
	Book searchBookByBookId(int bookId);
	
	Book searchBookByBookGenre(String bookGenre);

}
