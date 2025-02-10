package com.courselibraryy.courselibrary.controller;

import com.courselibraryy.courselibrary.entity.Book;
import com.courselibraryy.courselibrary.service.AuthorService;
import com.courselibraryy.courselibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
  @Autowired
  private BookService bookService;
   @Autowired
  private AuthorService authorService;
    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/books")
  public String findAllBook(Model model) {
    List<Book> books = bookService.findallBook();
    model.addAttribute("books", books);
  return "books";
  }
  @GetMapping("/remove-book/{id}")
  public String deleteBook(@PathVariable int id) {
      bookService.deleteBook(id);
      return "redirect:/books";
  }
  @GetMapping("/update-book/{id}")
  public String updateBook(@PathVariable int id, Model model) {
      Book book = bookService.findallBookById(id);
      model.addAttribute("book", book);
       model.addAttribute("authors", authorService.findAllAuthor());
      return "update-book";
  }
  @PostMapping("/save-update/{id}")
    public String updateBook(@PathVariable Long id, Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-book";
        }
        bookService.updateBook(book);
        model.addAttribute("books", bookService.findallBook());
        return "redirect:/books";
    }
    @GetMapping("/add-book")
    public String addBook(Book book, Model model) {
        model.addAttribute("authors", authorService.findAllAuthor());
        return "add-book";
    }

    @PostMapping("/save-book")
    public String saveBook(Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }
        bookService.createBook(book);
        model.addAttribute("books", bookService.findallBook());
        return "redirect:/books";
    }}

