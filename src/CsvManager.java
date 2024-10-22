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

public class CsvManager {
    private String filepath = "src/data.csv";
    
    public CsvManager(){
        
    }

    public void readFile(){
        BufferedReader reader = null;
        String line = "";

         try{
            reader =  new BufferedReader(new FileReader(filepath));
            while((line = reader.readLine()) != null){

                String[] row = line.split(",");

                for(String index : row){
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                reader.close();
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
            // TODO: handle exception
        }

        return students;
    }

    public String convertToCSV(String[] data) {
        String c = "";
        for(int i = 0; i<data.length; i++){
            c += data[i] + ",";
        }
        c = c.substring(0, c.length() - 1);
        return c;
    }


    private void clearFile(String filepath) throws IOException {
        PrintWriter writer = new PrintWriter(filepath);
        writer.print("");
        writer.close();
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
                info.write(convertToCSV(new String[]{s.name, s.lastname, s.email, s.group}) + "\n");
            }
            
            info.close();
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
