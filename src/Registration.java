package src;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Registration {
    Scanner scanner;
    CsvManager manager;
    public Registration(){
        scanner = new Scanner(System.in);
        manager = new CsvManager();
    }

    public Student promptUserData(){
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        System.out.println("Enter lastname: ");
        String lastname = scanner.nextLine();

        System.out.println("Enter email: ");
        String email = scanner.nextLine();

        System.out.println("Enter group: ");
        String group = scanner.nextLine();

        return new Student(name, lastname, email, group);
    }
    
    public void registerStudent(Student student, List<Student> students) throws IOException{
        students.add(student);
        manager.writeCSV(students);
    }

}
