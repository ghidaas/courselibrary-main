package com.courselibraryy.courselibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.courselibraryy.courselibrary.entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
