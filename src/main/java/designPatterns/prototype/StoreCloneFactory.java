package designPatterns.prototype;

public class StoreCloneFactory {
    public static Store getClone(Store store) throws CloneNotSupportedException {
        return store.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        BookStore bookStore1 = new BookStore("11", "Book World");
//        Load books for bookStore1
        bookStore1.loadBooks();

//        clone bookStore2 from StoreCloneFactory
        BookStore bookStore2 = (BookStore) StoreCloneFactory.getClone(bookStore1);

//        Modify books in bookStore1
        bookStore1.getBooks().remove(2);

        System.out.println(bookStore1.getName() +" " + bookStore1.getBooks());
        System.out.println(bookStore2.getName() +" " + bookStore2.getBooks());
    }
}
