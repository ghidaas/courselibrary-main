package com.courselibraryy.courselibrary.repository;

import com.courselibraryy.courselibrary.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepositry extends JpaRepository<Author, Integer> {

}
