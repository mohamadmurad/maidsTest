package com.murad.maidsTest.service;

import com.murad.maidsTest.model.Book;
import com.murad.maidsTest.model.BookBorrow;
import com.murad.maidsTest.model.Patron;
import com.murad.maidsTest.repository.BookBorrowRepository;
import com.murad.maidsTest.repository.BookRepository;
import com.murad.maidsTest.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class BorrowService {


    @Autowired
    private BookService bookService;
    @Autowired
    private PatronService patronService;

    @Autowired
    private PatronRepository patronRepository;
    @Autowired
    private BookBorrowRepository bookBorrowRepository;

    @Transactional(rollbackFor = Exception.class)
    public BookBorrow borrow(long bookId, long patronId) {
        Book book = bookService.getBook(bookId);
        Patron patron = patronService.getPatron(patronId);

        BookBorrow exists_book = bookBorrowRepository.findByBookAndIsReturned(book, false);
        if (exists_book == null) { // check if book borrow
            return bookBorrowRepository.save(new BookBorrow(book, patron));
        } else {
            throw new RuntimeException("Book already borrowed");
        }

    }


    public BookBorrow returnBook(Long bookId, Long patronId) {
        Book book = bookService.getBook(bookId);
        Patron patron = patronService.getPatron(patronId);

        BookBorrow exists_book = bookBorrowRepository.findByBookAndPatron(book, patron);
        if (exists_book == null) { // check if book borrow
            throw new RuntimeException("Patron not borrow this book");
        } else {
            if (exists_book.isIsReturned()) {
                throw new RuntimeException("Patron return book before");
            }
            exists_book.setIsReturned(true);
            return bookBorrowRepository.save(exists_book);
        }

    }
}
