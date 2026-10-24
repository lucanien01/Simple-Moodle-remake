package Classes;

public class Student extends Person {

    // Variables
    String classes;

    // Constructor
    public Student(int age, String name, String email, int login, String classes) {
        super(age, name, email, login);
        this.classes = classes;
    }

    // Getters
    public String getClasses() {
        return classes;
    }

    // Setters
    public void setClasses(String classes) {
        this.classes = classes;
    }

    // Converts student to string
    @Override
    public String toString(){
        return "Student: " + name + "   " + age + "   " + email + "   " + classes;
    }
}
