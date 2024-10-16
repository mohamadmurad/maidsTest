API
- Run APP :

      mvn spring-boot:run



- Books
  - GET : 127.0.0.1:8080/api/books All books
  - POST 127.0.0.1:8080/api/books : to store new book
  - GET 127.0.0.1:8080/api/books/{bookId} : to get book details
  - PUT 127.0.0.1:8080/api/books/{bookId} : to update book
  - DEL 127.0.0.1:8080/api/books/{bookId} : to delete book

- Patrons
    - GET : 127.0.0.1:8080/api/patrons All patrons
    - POST 127.0.0.1:8080/api/patrons : to store new patron
    - GET 127.0.0.1:8080/api/patrons/{patronId} : to get patron details
    - PUT 127.0.0.1:8080/api/patrons/{patronId} : to update patron
    - DEL 127.0.0.1:8080/api/patrons/{patronId} : to delete patron
  
- Borrowing 
  - POST 127.0.0.1:8080/api/borrow/{bookId}/patron/{patronId} : to borrow book 
  - PUT 127.0.0.1:8080/api/return/{bookId}/patron/{patronId} : to return book
