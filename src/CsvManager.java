package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CsvManager {
    private String filepath = "src/data.csv";
    Validator validator = new Validator();
    
    public CsvManager(){
        
    }

    public void readFile() {
        BufferedReader reader = null;
        String line = "";
        int[] columnWidths = null;
    
    
        try {
            reader = new BufferedReader(new FileReader(filepath));
            String[] colors = {
            Colors.GREEN,
            Colors.CYAN,
            Colors.BLUE,
            Colors.YELLOW
        };
    
            if ((line = reader.readLine()) != null) {
                String[] headers = line.split(",");
                
                
                columnWidths = new int[headers.length];
                for (int i = 0; i < headers.length; i++) {
                    columnWidths[i] = Math.max(headers[i].length(), 25);
                }
    
                for (int i = 0; i < headers.length; i++) {
                    System.out.print(colors[i]);
                    System.out.printf("%-" + columnWidths[i] + "s", headers[i]);
                    System.out.print(Colors.RESET);
                }
                System.out.println();
    
                for (int width : columnWidths) {
                    System.out.print(Colors.MAGENTA + "-".repeat(width) + Colors.RESET);
                }
                System.out.println();
            }
            
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                
                
                for (int i = 0; i < row.length; i++) {
 
                    System.out.print(colors[i]);
                    System.out.printf("%-" + columnWidths[i] + "s", row[i]);
                    System.out.print(Colors.RESET);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Student> getDataFromCSV(){
        BufferedReader reader = null;
        String line = "";
        List<Student> students = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(filepath));
            while((line = reader.readLine()) != null){
                String[] row = line.split(",");
                Student student = new Student(row[0], row[1], row[2], row[3]);
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public String convertToCSV(Student s) {
        String c = "";
        String[] data = {s.name, s.lastname, s.email, s.group};
        for(int i = 0; i<data.length; i++){
            c += data[i] + ",";
        }
        c = c.substring(0, c.length() - 1);
        return c;
    }



    public void writeCSV(List<Student> data) throws IOException{
        
        try {
            File file = new File(filepath);
            FileWriter writer = new FileWriter(filepath);
            BufferedWriter info = new BufferedWriter(writer);
            
            if (file.length() == 0) {
                info.write("name, lastname, email, group");
                info.newLine();
            }

            for (Student s : data) {
                
                info.write(convertToCSV(s) + "\n");
            }
            
            info.close();
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
