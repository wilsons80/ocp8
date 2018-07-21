package simulado02;

import java.util.HashMap;
import java.util.Map;


public class BookStore {
    Map<Book, Integer> map = new HashMap<Book, Integer>();    
  
    public BookStore(){
        Book b = new Book("A111");
        map.put(b, 10);
        b = new Book("B222");
        map.put(b, 5);
    }
    
    Integer getNumberOfCopies(Book b){
        return map.get(b);
    }

    public static void main(String[] args){
        BookStore bs = new BookStore();
        Book b = new Book("A111");
        System.out.println(bs.getNumberOfCopies(b));  //1
        
        System.out.println(new Book("aaa").hashCode());
        System.out.println(new Book("aaa").hashCode());
        System.out.println(new Book("aaa").hashCode());
        System.out.println(new Book("aaa").hashCode());
        System.out.println(new Book("aaa").hashCode());
    }
    
}