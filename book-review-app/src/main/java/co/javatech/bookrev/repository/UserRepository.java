package co.javatech.bookrev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.javatech.bookrev.entity.Books;
import co.javatech.bookrev.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	 @Query("SELECT u FROM User u WHERE u.email = ?1")
	    public User findByEmail(String email);

	//public Books save(Books book);

}
