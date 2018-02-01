package com.bookstore.all;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public Collection<Book> findAllBooks(){
		List<Book> books = new ArrayList<>();
		books = (List<Book>) bookRepository.findAll();
		return books;
		
	}
	public Book finOne(long id){
		return bookRepository.findOne(id);
	}
	
	public void save(Book book){
		bookRepository.save(book);
	}
	public void delete(long id){
		bookRepository.delete(id);
	}
	
	
}
