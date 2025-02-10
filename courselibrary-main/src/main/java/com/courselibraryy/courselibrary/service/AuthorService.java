package com.courselibraryy.courselibrary.service;

import com.courselibraryy.courselibrary.entity.Author;
import com.courselibraryy.courselibrary.repository.AuthorRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {
  @Autowired
  private AuthorRepositry authorRepository;
  public List<Author> findAllAuthor(){
    return authorRepository.findAll();
  }
  public Author findAuthorById(int id){
   Author author =authorRepository.findById(id).orElseThrow(()->new RuntimeException("Author not found"));
   return author;
  }
  public void createAuthor(Author author){
      authorRepository.save(author);
  }
  public void updateAuthor(Author author){
      authorRepository.save(author);
  }
  public void deleteAuthor(int id){
      Author author =authorRepository.findById(id).orElseThrow(()->new RuntimeException("Author not found"));
      authorRepository.deleteById(author.getId());
  }

}
