package com.murad.maidsTest.repository;

import com.murad.maidsTest.model.Book;
import com.murad.maidsTest.model.BookBorrow;
import com.murad.maidsTest.model.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookBorrowRepository extends JpaRepository<BookBorrow, Long> {

    BookBorrow findByBookAndIsReturned(Book book, boolean is_returned);
    BookBorrow findByBookAndPatron(Book book,Patron patron);
}
