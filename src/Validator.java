package src;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Collections;


public class Validator {
    public Validator(){

    }

    public boolean listContainsName(List<Student> students, String name){
        return students.stream().anyMatch(s -> s.name.equalsIgnoreCase(name));
    }

    public boolean isUserUnique(List<Student> list, Student student){

        List<String> lastNames = new ArrayList<>();
        List<String> emails = new ArrayList<>();

        for(int i = 0; i<list.size(); i++){
            lastNames.add(list.get(i).name);
            emails.add(list.get(i).lastname);

        }

        int lastnameCount = Collections.frequency(lastNames, student.name);
        int emailCount = Collections.frequency(emails, student.email);


        if(lastnameCount > 0 || emailCount > 0){
            return false;
        }

        return true;
    }

    public boolean fieldsArentEmpty(Student student){
        if(
            student.name.isEmpty() ||
            student.lastname.isEmpty() ||
            student.email.isEmpty() ||
            student.group.isEmpty()
        ){
            return false;
        }
        return true;
    }

}
