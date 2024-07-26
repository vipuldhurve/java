package designPatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class BookStore extends Store {
    private List<Book> books;

    public BookStore() {}

    public BookStore(String id, String name) {
        super(id, name);
        this.books = new ArrayList<>();
    }

//    A dummy method that gets books from database
    public void loadBooks(){
        System.out.println("Loading books from database for store: " + this.getName());
        for(int i =1; i<=5; i++){
            this.getBooks().add(new Book("bid-"+i , "Book-" + i));
        }
    }

//    Updated deep clone method in subclass
    @Override
    public BookStore clone() {
        BookStore bookStoreClone = new BookStore();
        bookStoreClone.setId(this.getId()+1);
        bookStoreClone.setName(this.getName() + " v2");
        System.out.println("Cloned book store: " + this.getName()
                + " to create: " + bookStoreClone.getName());
        List<Book> booksClone = new ArrayList<>();
//        Making a deep copy of books
        for(Book book: this.getBooks() ){
            booksClone.add(book);
        }
        bookStoreClone.setBooks(booksClone);
        return bookStoreClone;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
