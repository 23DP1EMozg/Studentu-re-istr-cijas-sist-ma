package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Registration registration = new Registration();
        CsvManager csvManager = new CsvManager();
        StudentManager studentManager = new StudentManager();
        
        //init
        List<Student> students = studentManager.getStudentsList();


        while (true) {
            
            System.out.println();
            System.out.println("register / show / remove / exit");
            String ans = scanner.nextLine();

            if(ans.equalsIgnoreCase("register")){
                Student student = registration.promptUserData();
                registration.registerStudent(student);
            }else if(ans.equalsIgnoreCase("SHOW")){
                csvManager.readFile();
            }else if(ans.equalsIgnoreCase("REMOVE")){
                System.out.println("Enter the name of the student which you want to remove: ");
                String name = scanner.nextLine();
                studentManager.removeStudent(name);
            }else if(ans.equalsIgnoreCase("exit")){
                break;
            }else{
                System.out.println("invalid input");
            }

        }

        

        scanner.close();
        


        


    }
}
