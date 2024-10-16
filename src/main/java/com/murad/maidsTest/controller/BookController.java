package com.murad.maidsTest.controller;

import com.murad.maidsTest.model.Book;
import com.murad.maidsTest.response.SuccessResponse;
import com.murad.maidsTest.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController extends BaseApiController {


    @Autowired
    private BookService bookService;


    //get all the Books in the table in our database
    @GetMapping("/books")
    public SuccessResponse getBooks() {
        return new SuccessResponse("success", bookService.getBooks());
    }


    //get a single Book by its id
    @GetMapping("/books/{id}")
    public SuccessResponse getBook(@PathVariable long id) {
        Book Book = bookService.getBook(id);
        return new SuccessResponse("success", Book);

    }


    // insert a Book into database
    @PostMapping("/books")
    public SuccessResponse saveBook(@Valid @RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        return new SuccessResponse("success", savedBook);

    }

    //update an existing Book in the database
    @PutMapping("/books/{id}")
    public SuccessResponse updateBook(@PathVariable long id, @Valid @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        return new SuccessResponse("success", updatedBook);
    }


    // delete an existing Book in the database
    @DeleteMapping("/books/{id}")
    public SuccessResponse deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
        return new SuccessResponse("success", null);

    }


}
