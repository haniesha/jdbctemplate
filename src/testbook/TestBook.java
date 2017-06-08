package testbook;

import java.awt.print.Book;

import jdbcexample.BookDao;

public class TestBook {


	
		
		public static void main(String args[])
		{
			BookDao book= new BookDao();
			
			System.out.println(book.findAll());
			
			System.out.println(book.findTotalBook());
			
			Book cc= new Book();
			
			cc.setBook_id(26);
			cc.setBook_name("Ranjana");
			cc.setAuthor("shivkhera");
			
		book.saveOrUpdate(cc);
		book.delete(25);
		}

	}


}
