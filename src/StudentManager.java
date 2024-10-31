package src;
import java.util.List;
import java.util.Optional;
import java.io.IOException;
import java.util.ArrayList;

public class StudentManager {
    private List<Student> students;
    CsvManager manager;
    public StudentManager(){
        manager = new CsvManager();
        students = initStudentsList();

    }

    private List<Student> initStudentsList(){
        List<Student> list = manager.getDataFromCSV();
        if(list.size() > 0){
            list.remove(0);
        }
        return list;
    }

    public List<Student> getStudentsList(){
        List<Student> list = manager.getDataFromCSV();
        students = new ArrayList<>(list);

        if(students.size() > 0){
            students.remove(0);
        }

        return students;
    }

    public List<Student> addToStudentsList(Student student){
        students.add(student);
        return students;
    }


    public void removeStudent(String name){
        List<Student> students = manager.getDataFromCSV();
        
        Optional<Student> student = students.stream().filter(s -> s.name.equalsIgnoreCase(name)).findFirst();

        if(student.isEmpty()){
            System.out.println("There isnt a user with the name " + name + " in the file");
        }else{
            Student s = student.get();
            students.remove(s);
        }

        if(students.size() > 0){
            students.remove(0);
        }

        try {
            manager.writeCSV(students);
            System.out.println(student.get().name + " has benn removed!");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
