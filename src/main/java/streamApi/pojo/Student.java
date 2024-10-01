package streamApi.pojo;

public class Student {
    private long id;
    private String country;
    private String subject;
    private int age;
    private int marks;

    public Student(long id, String country, String subject, int age, int marks) {
        this.id = id;
        this.country = country;
        this.subject = subject;
        //min age = 18 and max age = 100
        if(age<18) age = 18;
        else if(age>100) age=100;
        this.age = age;
        //min marks = 0 and max marks = 100
        if(marks < 0) marks = 0;
        else if(marks > 100) marks = 100;
        this.marks = marks;
    }

    public long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getSubject() {
        return subject;
    }

    public int getAge() {
        return age;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", subject='" + subject + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                '}';
    }
}
