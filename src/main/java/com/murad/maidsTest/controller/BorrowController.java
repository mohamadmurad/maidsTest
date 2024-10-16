package com.murad.maidsTest.controller;

import com.murad.maidsTest.model.Book;
import com.murad.maidsTest.model.BookBorrow;
import com.murad.maidsTest.service.BookService;
import com.murad.maidsTest.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BorrowController extends BaseApiController{


    @Autowired
    private BorrowService borrowService;


    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<Object> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        try {
            BookBorrow savedBook = borrowService.borrow(bookId, patronId);
            return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<Object> returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        try {
            BookBorrow savedBook = borrowService.returnBook(bookId, patronId);
            return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }


}
