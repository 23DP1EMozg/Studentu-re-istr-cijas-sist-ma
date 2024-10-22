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
        
        //init
        List<Student> students = csvManager.getDataFromCSV();
        if(students.size() > 0){
            students.remove(0);
        }


        System.out.println("register / show / remove / exit");
        String ans = scanner.nextLine();

        if(ans.toUpperCase() == "REGISTER"){
            Student student = registration.promptUserData();            
            students.add(student);
            csvManager.writeCSV(students);
        }else if(ans.toUpperCase() == "SHOW"){
            csvManager.readFile();
        }


        scanner.close();
        


        


    }
}
