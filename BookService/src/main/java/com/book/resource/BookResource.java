package com.book.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.Book;
import com.book.service.BookService;

@RestController
public class BookResource {

	@Autowired
	private BookService bookService;

	@GetMapping(path = "/bookId/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book searchBookByBookIdResource(@PathVariable("bookId") int bookId) {
		return bookService.searchBookByBookId(bookId);
	}

	@GetMapping(path = "/book/{bookGenre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book searchBookByBookGenreResource(@PathVariable("bookGenre") String bookGenre) {
		return bookService.searchBookByBookGenre(bookGenre);
	}
}
