package com.murad.maidsTest.service;

import com.murad.maidsTest.model.Book;
import com.murad.maidsTest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }


    public Book getBook(long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Not Found"));
    }


    public List<Book> getBooks() {
        return bookRepository.findAll();
    }


    public Book updateBook(long bookId, Book Book) {
        Book existingBook = this.getBook(bookId);
        existingBook.setTitle(Book.getTitle());
        existingBook.setAuthor(Book.getAuthor());
        existingBook.setISBN(Book.getISBN());
        existingBook.setPublication_year(Book.getPublication_year());
        bookRepository.save(existingBook);
        return existingBook;
    }


    public Book deleteBook(long bookId) {
        Book existingBook = this.getBook(bookId);
        bookRepository.deleteById(bookId);
        return existingBook;
    }


}
