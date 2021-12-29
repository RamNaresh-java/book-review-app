package co.javatech.bookrev;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import co.javatech.bookrev.entity.Books;
import co.javatech.bookrev.repository.BooksRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class BooksRepositoryTests {
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
    private BooksRepository repo;
	
	@Test
    public void testCreateBooks() {
        Books book = new Books();
        book.setBookId(851478L);
        book.setBookTitle("Java Complete Reference");
        book.setBookAuthor("James Gosling");
        book.setBookPrice(745.25f);
         
        Books savedBook = repo.save(book);
         
        Books existBook = entityManager.find(Books.class, savedBook.getBookId());
         
        assertThat(book.getBookTitle()).isEqualTo(existBook.getBookTitle());
         
    }

}
