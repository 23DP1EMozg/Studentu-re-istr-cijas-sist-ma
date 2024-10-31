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
    
    public void registerStudent(Student student) throws IOException{
        List<Student> students = studentManager.getStudentsList();
        boolean unique = validator.isUserUnique(students, student);
        boolean fieldsArentEmpty = validator.fieldsArentEmpty(student);



        if(unique && fieldsArentEmpty){
            List<Student> updatedList = studentManager.addToStudentsList(student);
            csvManager.writeCSV(updatedList);
            System.out.println(student.name + " has been added!");
        }else{
            System.out.println("There was a problem with adding the student");
        }

    }

}
