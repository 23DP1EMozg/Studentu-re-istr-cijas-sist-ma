package src;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Registration {
    Scanner scanner;
    CsvManager csvManager;
    Validator validator;
    StudentManager studentManager;
    public Registration(){
        scanner = new Scanner(System.in);
        csvManager = new CsvManager();
        validator = new Validator();
        studentManager = new StudentManager();
    }

    public Student promptUserData(){
        System.out.println(Colors.YELLOW + "Enter name: " + Colors.RESET);
        String name = scanner.nextLine();

        System.out.println(Colors.YELLOW + "Enter lastname: " + Colors.RESET);
        String lastname = scanner.nextLine();

        System.out.println(Colors.YELLOW + "Enter email: " + Colors.RESET);
        String email = scanner.nextLine();

        System.out.println(Colors.YELLOW + "Enter group: " + Colors.RESET);
        String group = scanner.nextLine();

        return new Student(name, lastname, email, group);
    }
    
    public void registerStudent(Student student) throws IOException{
        List<Student> students = studentManager.getStudentsList();
        boolean unique = validator.isUserUnique(students, student);
        boolean fieldsArentEmpty = validator.fieldsArentEmpty(student);



        if(unique && fieldsArentEmpty){
            List<Student> updatedList = studentManager.addToStudentsList(student);
            csvManager.writeCSV(updatedList);
            System.out.println(Colors.MAGENTA + student.name +Colors.RESET + Colors.GREEN + " has been added!" + Colors.RESET);
        }else{
            System.out.println(Colors.RED + "There was a problem with adding the student" + Colors.RESET);
        }

    }

}
