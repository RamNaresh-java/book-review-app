package co.javatech.bookrev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="book_review")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	
	@Column(name="book_title", nullable=false, unique=true, length=45)
	private String bookTitle;
	
	@Column(name="book_author", nullable=false, length=45)
	private String bookAuthor;
	
	@Column(name="book_price", nullable=false)
	private Float bookPrice;
	
	@Column(name="book_rating")
	private float stars;

}
