/**
 * Modification of EvaluateExpression
 * @author Liang
 *
 */
/* Harrison Jordan
 * CS 3401
 * Section 02
 * Prof. Gayler
 * 03/09/2015
 * Midterm
 */
public class Book {

	private String title;
	private String author;
	private String ISBN;
	
	public Book(){
		
	}
	
	public Book(String title, String author, String ISBN){
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getISBN() {
		return ISBN;
	}
	
	
	
}
