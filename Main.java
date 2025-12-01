//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now(); //set the exact date and hold that in today variable
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd,yyyy"); // which format i want like MMM dd yyyy or dd MMM yyyy

        System.out.println("Shawon Kumar Singha");
        System.out.println("Course name : Spring Boot Development");
        System.out.println("My goal is to use JPA/Hibernate, CRUD operations, MySQL/PostgreSQL");
        System.out.println("The current date today : " +today.format(format));
        System.out.println("Hello, fellow developers");

        System.out.println();
        System.out.println();
        System.out.println("\t\t\t ### Module Summary ###");
        System.out.println("I learn about how to setup development environment, Basic about package & class, How to run project in console");
        System.out.println("FOr this course i create total 5 projects");
        System.out.println("The reason , i created all those project to learn different thing like how to import realtime , realdate");
        System.out.println("Till now it is okay for me.");
    }
}