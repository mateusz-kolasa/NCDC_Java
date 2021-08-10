package ncdc.assessment.java.domain;


import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import ncdc.assessment.java.validation.AuthorAnnotation;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Book {
	@Id
	@NotNull
	private long isbn;
	
	@NotNull
	@Length(min = 1, max = 256)
	@AuthorAnnotation
	private String author;
	
	@NotNull
	@Length(min = 1, max = 256)
	private String title;
	
	public Book() {
		
	}
	
	public Book(String author, String title, long isbn) {
		super();
		this.author = author;
		this.title = title;
		this.isbn = isbn;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}	
}
