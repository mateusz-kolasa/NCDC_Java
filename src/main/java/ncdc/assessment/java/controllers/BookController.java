package ncdc.assessment.java.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ncdc.assessment.java.domain.Book;
import ncdc.assessment.java.services.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String bookList(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "list_page";
	}
}
