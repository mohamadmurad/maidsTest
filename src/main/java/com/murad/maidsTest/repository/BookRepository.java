package com.murad.maidsTest.repository;

import com.murad.maidsTest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  BookRepository extends JpaRepository<Book, Long> {
}
