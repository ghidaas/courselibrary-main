package com.courselibraryy.courselibrary.service;

import com.courselibraryy.courselibrary.entity.Book;
import com.courselibraryy.courselibrary.repository.BookRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
@Autowired
private BookRepository bookRepository;
public List<Book> findallBook() {
return bookRepository.findAll();
}
    public Book findallBookById(int id) {
   Book book=bookRepository.findById(id).orElseThrow(()-> new RuntimeException("book not found"));
   return book;
}
public void createBook(Book book) {
bookRepository.save(book);
}
public void updateBook(Book book){
    bookRepository.save(book);
    }
public void deleteBook(int id) {
    Book book=bookRepository.findById(id).orElseThrow(()-> new RuntimeException("book not found"));
    bookRepository.deleteById(book.getId());
}
}