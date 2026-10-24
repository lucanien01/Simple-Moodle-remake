package Classes;

public abstract class Person {

    // Variables
    int age;
    int login;
    String name;
    String email;

    // Constructor
    Person(int age, String name, String email, int login){
        this.age = age;
        this.name = name;
        this.email = email;
        this.login = login;
    }

    // Getters
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getLogin() {
        return login;
    }

    // Setters
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    @Override
    public String toString(){
        return "";
    }
}
