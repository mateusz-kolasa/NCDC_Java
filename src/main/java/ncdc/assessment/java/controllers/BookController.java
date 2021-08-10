package ncdc.assessment.java.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@GetMapping("/book/add")
	public String addRecordForm(Model model) {
        model.addAttribute("book", new Book());
		return "new_record_page";
	}
	
	@PostMapping("/book/add")
	public String addRecord(@ModelAttribute @Valid Book book, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "new_record_page";
		}
		return "redirect:/";
	}
}
