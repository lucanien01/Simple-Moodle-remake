package Classes;

import Enums.Subjects;

public class Teacher extends Person{
    Subjects subjects;
    int id;

    // Constructor
    public Teacher(int id, int age, String name, String email, int login, Enums.Subjects subjects) {
        super(age, name, email, login);
        this.id = id;
        this.subjects = subjects;
    }

    // Getters
    public Subjects getSubjects() {
        return subjects;
    }

    public int getId() {
        return id;
    }

    // Setters
    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Converts teacher to string
    @Override
    public String toString(){
        return "Teacher: " + id + "   " + name + "   " + age + "   " + email + "   " + subjects;
    }
}
