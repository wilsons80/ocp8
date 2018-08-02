package simulado03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Book implements Comparator<Book>{
    String isbn;
    String title;
    public Book(String isbn, String title){
        this.isbn = isbn;
        this.title = title;
    }
    
    

    
    public static void main(String[] args) {
		
    	List<Book> books = getBooksByAuthor("Ludlum");
    	//books.stream().sorted((a,b) -> a.getIsbn().compareTo(b.getIsbn())).forEach(b->System.out.println(b.getIsbn())); //1
    	books.stream().sorted().forEach(b->System.out.println(b.getIsbn())); //1
    	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

	private static List<Book> getBooksByAuthor(String string) {
		List<Book> retorno = new ArrayList<>();
		retorno.add(new Book("123a", "t1a"));
		retorno.add(new Book("123b", "t1b"));
		retorno.add(new Book("123c", "t1c"));
		retorno.add(new Book("123d", "t1d"));
		return retorno;
	}
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}




	@Override
	public int compare(Book o,Book a) {
		// TODO Auto-generated method stub
		return this.getIsbn().compareTo(o.getIsbn());
	}
}



