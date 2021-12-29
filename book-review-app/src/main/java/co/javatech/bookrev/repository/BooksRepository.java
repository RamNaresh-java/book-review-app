package co.javatech.bookrev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.javatech.bookrev.entity.Books;

public interface BooksRepository extends JpaRepository<Books, Long>{

}
