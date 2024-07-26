package designPatterns.prototype;

public abstract class Store implements Cloneable{
    protected String id;
    protected String name;


    public Store() {}

    public Store(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Store clone() throws CloneNotSupportedException {
        return (Store)super.clone();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
