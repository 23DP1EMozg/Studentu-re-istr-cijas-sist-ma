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
        

        while (true) {
            
            System.out.println();
            System.out.println(Colors.CYAN + "register " + Colors.RESET +
             Colors.MAGENTA + " / show" + Colors.RESET +
             Colors.RED + " / remove " + Colors.RESET +
             Colors.BLACK +" / exit" + Colors.RESET);
            String ans = scanner.nextLine();

            if(ans.equalsIgnoreCase("register")){
                Student student = registration.promptUserData();
                registration.registerStudent(student);
            }else if(ans.equalsIgnoreCase("SHOW")){
                csvManager.readFile();
            }else if(ans.equalsIgnoreCase("REMOVE")){
                System.out.println(Colors.YELLOW + "Enter the name of the student which you want to remove: " + Colors.RESET);
                String name = scanner.nextLine();
                studentManager.removeStudent(name);
            }else if(ans.equalsIgnoreCase("exit")){
                System.out.println(Colors.MAGENTA + "Goodbye!" + Colors.RESET);
                break;
            }else{
                System.out.println(Colors.RED + "invalid input" + Colors.RESET);
            }

        }

        

        scanner.close();
        


        


    }
}
