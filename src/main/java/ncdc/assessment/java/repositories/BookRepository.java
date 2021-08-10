package ncdc.assessment.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ncdc.assessment.java.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
}
