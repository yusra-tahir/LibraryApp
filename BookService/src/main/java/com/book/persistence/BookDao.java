package com.book.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.entity.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

	public Book findBookByBookId(int bookId);
	
	public Book findBookByBookGenre(String bookGenre);
	
}
