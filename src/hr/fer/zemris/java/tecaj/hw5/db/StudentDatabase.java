package hr.fer.zemris.java.tecaj.hw5.db;

import hr.fer.zemris.java.tecaj.hw5.collections.SimpleHashtable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by akarlovic on 8.2.2017..
 */
public class StudentDatabase {
    SimpleHashtable<String, StudentRecord>  index;
    List<StudentRecord> students;

    StudentDatabase(List<String> students){
        this.students = new ArrayList<StudentRecord>();
        Iterator<String> it = students.iterator();
        while(it.hasNext()){
            String student = it.next();
            String[] studentData = student.split("\\s");
            this.students.add(new StudentRecord(studentData));
        }
    }

    public StudentRecord forJMBAG(String jmbag){
        return index.get((Object)(jmbag));
    }
    public List<StudentRecord> filter(IFilter filter){
        return null;
    }
}
