package designPatterns.prototype;

public class Book {
    private String Id;
    private String name;

    public Book(String id, String name) {
        Id = id;
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
