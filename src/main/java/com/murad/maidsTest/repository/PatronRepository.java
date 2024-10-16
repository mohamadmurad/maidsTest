package com.murad.maidsTest.repository;

import com.murad.maidsTest.model.Book;
import com.murad.maidsTest.model.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepository extends JpaRepository<Patron, Long> {
}
