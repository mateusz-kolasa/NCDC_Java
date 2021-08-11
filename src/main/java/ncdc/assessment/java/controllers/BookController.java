package ncdc.assessment.java.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		if (!bookService.isIsbnUnique(book))
			bindingResult.addError(new FieldError("book", "isbn", "ISBN must be unique"));
		
		if (bindingResult.hasErrors()) {
			return "new_record_page";
		}
		
		bookService.addBook(book);
		return "redirect:/";
	}
	
	@GetMapping("/getAllBooks")
	public ResponseEntity<List<Book>> getAllBooks(){
		return new ResponseEntity<List<Book>>(bookService.getAllBooks(), HttpStatus.OK);
	}
	
	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody @Valid Book book){
		book = bookService.addBook(book);
		if (book == null)
			return new ResponseEntity<Book>(new Book(), HttpStatus.BAD_REQUEST);
			
		return new ResponseEntity<Book>(bookService.addBook(book), HttpStatus.OK);
	}
}
