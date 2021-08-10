package ncdc.assessment.java.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ncdc.assessment.java.domain.Book;
import ncdc.assessment.java.repositories.BookRepository;

@Service
public class BookService {
	private static final Logger logger = LoggerFactory.getLogger(BookService.class);
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		logger.info("Geting all books");
		List<Book> books = bookRepository.findAll();
		logger.info("Found {} books", books.size());
		return bookRepository.findAll();
	}
}
