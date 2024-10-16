package com.murad.maidsTest;

import com.murad.maidsTest.model.Book;
import com.murad.maidsTest.repository.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookRepositoryTest {

	@Autowired
	private BookRepository underTest;

	@Test
	@DisplayName("Test 1:Save Book Test")
	@Order(1)
	@Rollback(value = false)
	public void saveBookTest(){

		//Action
		Book book = new Book();
		book.setISBN("Sam");
		book.setTitle("Sam");
		book.setPublication_year("2024");
		book.setAuthor("Author");
		underTest.save(book);
		//Verify
		System.out.println(book);
		Assertions.assertThat(book.getId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	public void getBookTest(){

		//Action
		Book book = underTest.findById(1L).orElse(null);
		Assertions.assertThat(book).isNotNull();
		//Verify
		System.out.println(book);
		Assertions.assertThat(book.getId()).isEqualTo(1L);
	}

	@Test
	@Order(3)
	public void getListOfBooksTest(){
		//Action
		List<Book> books = underTest.findAll();
		//Verify
		System.out.println(books);
		Assertions.assertThat(books.size()).isGreaterThan(0);

	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateBookTest(){

		//Action
		Book book = underTest.findById(1L).orElse(null);
		Assertions.assertThat(book).isNotNull();
		book.setAuthor("author 1");
		Book updatedBook =  underTest.save(book);

		//Verify
		System.out.println(updatedBook);
		Assertions.assertThat(updatedBook.getAuthor()).isEqualTo("author 1");

	}

	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteBookTest(){
		//Action
		underTest.deleteById(1L);
		Optional<Book> book = underTest.findById(1L);

		//Verify
		Assertions.assertThat(book).isEmpty();
	}
}
