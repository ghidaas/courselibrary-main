package com.courselibraryy.courselibrary;

import com.courselibraryy.courselibrary.entity.Author;
import com.courselibraryy.courselibrary.entity.Book;
import com.courselibraryy.courselibrary.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourselibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourselibraryApplication.class, args);
	}
	@Bean
	public CommandLineRunner initialCreate(BookService bookService) {
		return (args) -> {
			Book book1 = new Book("2", "mohammed", "description",2009);
			Author author1 = new Author("mohammed", "description");
			book1.addAuthor(author1);
			bookService.createBook(book1);


		};
   }
}
