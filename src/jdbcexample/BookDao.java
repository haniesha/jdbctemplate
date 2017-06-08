package jdbcexample;

import java.awt.print.Book;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;




public class BookDao {
private JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	
	public List<Book> findAll(){

		String sql = "SELECT * FROM BOOK";

		List<Book> books  = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper(book.class));

		return books;
	}
	
	public int findTotalBook(){

		String sql = "SELECT COUNT(*) FROM BOOK";

		int total = jdbcTemplate.queryForInt(sql);

		return total;
	}
	
	public void saveOrUpdate(Book book) {
	    if (book.getBook_id() < 0) {
	        // update
	        String sql = "UPDATE book SET book_id=?, book_name=?, age=?, "
	                    + " WHERE book_id=?";
	        jdbcTemplate.update(sql, book.getBook_id(), book.getBook_name(),
	                book.getAuthor(),book.getBook_id());
	    } else {
	        // insert
	        String sql = "INSERT INTO book (book_id,book_name,author)"
	                    + " VALUES (?, ?, ?)";
	        jdbcTemplate.update(sql, book.getBook_id(), book.getBook_name(),
              book.getauthor());
	    }
	 
	}
	
	public void delete(int book_id) {
	    String sql = "DELETE FROM book WHERE book_id=?";
	    jdbcTemplate.update(sql, book_id);
	    
	    System.out.println("Successfully deleted");
	}
	

}
