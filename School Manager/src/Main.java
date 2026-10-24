import Classes.Person;
import Classes.Schedule;
import Classes.Student;
import Classes.Teacher;
import Enums.Subjects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    // Variables
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Person> persons = new ArrayList<>();
    private List<Schedule> schedules = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    private Person loggedInUser;
    private boolean isFound;

    // Main loop
    void main() {

        addTeachers();
        addStudents();
        mergeLists();
        login();
        user();

    }

    public void mergeLists(){
        persons.addAll(teachers);
        persons.addAll(students);
    }

    public void addTeachers(){

        // Teachers
        teachers.add(new Teacher(9273, 35, "Soren", "Soren123@gmail.com", 15923, Subjects.SoftwareConstruction));
        teachers.add(new Teacher(4872, 42, "Bob", "BobTheGreat@gmail.com",48723 ,Subjects.SoftwareDesign));
        teachers.add(new Teacher(3927, 78, "Lars", "IEatDirt53@gmail.com", 98424,Subjects.IT_Business));
    }

    public void addStudents(){

        // Students
        students.add(new Student(25, "Lucas", "Lucanien123@gmail.com", 32423,"Programming"));
        students.add(new Student(24, "Alex", "AlexLikesPotatoes@gmail.com", 22963,"Programming"));
        students.add(new Student(27, "Simon", "SimonFromDenmark@gmail.com", 58239,"Programming"));
    }

    public void login(){
        System.out.print("Moodle\n");
        while(!isFound) {
            System.out.print("1. Login\n");
            System.out.print("2. Exit\n");

            int choice = scanner.nextInt();

            if(choice == 1) {
                System.out.print("\nEnter login: ");
                int login = scanner.nextInt();

                for (Person person : persons) {
                    if (person.getLogin() == login) {
                        System.out.println("\nWelcome " + person.getName());
                        loggedInUser = person;
                        isFound = true;
                        break;
                    }
                }

                if (!isFound) {
                    System.out.println("Invalid login");
                }

            } else if(choice == 2) {
                System.exit(0);
            } else {
                System.out.println("Invalid type, try again");
            }
        }
    }

    public void user(){

        while(true) {
            if (loggedInUser instanceof Student) {
                System.out.print("\nPlease select an option\n");
                System.out.print("1. My Info\n");
                System.out.print("2. Teachers\n");
                System.out.print("3. Schedule\n");
                System.out.print("4. Loans\n");
                System.out.print("5. Exit\n");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Name: " + loggedInUser.getName() + "\n");
                        System.out.print("Age: " + loggedInUser.getAge() + "\n");
                        System.out.print("Email: " + loggedInUser.getEmail() + "\n");
                        System.out.print("Classes: " + ((Student) loggedInUser).getClasses() + "\n");
                        goBack();
                        whiteSpace();
                        break;
                    case 2:
                        teachers();
                        goBack();
                        whiteSpace();
                        break;
                    case 3:
                        schedule();
                        goBack();
                        whiteSpace();
                        break;
                    case 4:
                        System.out.print("You currently don't have any loans\n");
                        goBack();
                        whiteSpace();
                        break;
                    case 5:
                        System.out.print("Have a nice day!\n");
                        System.exit(0);
                        break;
                }
            }
            if (loggedInUser instanceof Teacher) {
                System.out.print("Please select an option\n");
                System.out.print("1. My Info\n");
                System.out.print("2. Students\n");
                System.out.print("3. Schedule\n");
                System.out.print("4. Exit\n");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("\nName: " + loggedInUser.getName() + "\n");
                        System.out.print("Age: " + loggedInUser.getAge() + "\n");
                        System.out.print("Email: " + loggedInUser.getEmail() + "\n");
                        System.out.print("Subjects: " + ((Teacher) loggedInUser).getSubjects() + "\n");
                        System.out.print("Id: " + ((Teacher) loggedInUser).getId() + "\n");
                        goBack();
                        whiteSpace();
                        break;
                    case 2:
                        students();
                        goBack();
                        whiteSpace();
                        break;
                    case 3:
                        schedule();
                        goBack();
                        whiteSpace();
                        break;
                    case 4:
                        System.out.print("Have a nice day!\n");
                        System.exit(0);
                        break;
                }
            }
        }
    }

    public void students(){
        System.out.print("\nSTUDENTS\n");
        System.out.printf("%-8s %-5s %-30s %-20s%n", "Name", "Age", "Email", "Classes");

        for (Student student : students) {
            System.out.printf("%-8s %-5d %-30s %-20s%n",
                    student.getName(),
                    student.getAge(),
                    student.getEmail(),
                    student.getClasses());
        }
    }

    public void teachers(){
        System.out.print("\nTEACHERS\n");
        System.out.printf("%-7s %-8s %-5s %-25s %-20s%n", "ID", "Name", "Age", "Email", "Subjects");

        for (Teacher teacher : teachers) {
            System.out.printf("%-7d %-8s %-5d %-25s %-20s%n",
                    teacher.getId(),
                    teacher.getName(),
                    teacher.getAge(),
                    teacher.getEmail(),
                    teacher.getSubjects());
        }
    }

    public void goBack(){
        System.out.print("\nType Y back\n");
        String back = scanner.next();
        System.out.print("\n");
    }

    public void schedule(){
        Schedule schedule1 = new Schedule(
                LocalDate.of(2026, 11, 1),
                8.05,
                "Software Construction",
                "B205"
        );
        Schedule schedule2 = new Schedule(
                LocalDate.of(2026, 11, 2),
                8.35,
                "Software Construction",
                "B205"
        );
        Schedule schedule3 = new Schedule(
                LocalDate.of(2026, 11, 3),
                8.45,
                "Software Construction",
                "B205"
        );
        schedules.add(schedule1);
        schedules.add(schedule2);
        schedules.add(schedule3);

        for (Schedule schedule : schedules) {
            System.out.println(schedule.toString());
        }
    }

    public void whiteSpace(){
        for (int i = 0; i < 15; i++){
            System.out.println();
        }
    }
}