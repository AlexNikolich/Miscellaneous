package com.bookstore.all;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControllerMainn {
	
	@Autowired
	 BookService bookService;
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping(value="/")
	public String getAllBooks(HttpServletRequest req){
		req.setAttribute("books", bookService.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		return "index1";
	}
	
	@GetMapping("/updateBook")
	public String updateBook(@RequestParam long id, HttpServletRequest req){
		req.setAttribute("book", bookService.finOne(id));
		req.setAttribute("mode", "BOOK_EDIT");
		return "index1";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), false));
	}
	
	@PostMapping("/save")
	public void updateBook(@ModelAttribute Book book, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse res) throws IOException{
		bookService.save(book);
		req.setAttribute("books", bookService.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		res.sendRedirect("/");
	}
	
	@GetMapping("/newBook")
	public String createBook(HttpServletRequest req){
		req.setAttribute("mode", "BOOK_NEW");
		return "index1";
	}
	@GetMapping("/deleteBook")
	public void deleteBook(@RequestParam long id, HttpServletRequest req,HttpServletResponse res) throws Exception{
		bookRepository.delete(id);
		res.sendRedirect("/");
	}
		
	
	

}
