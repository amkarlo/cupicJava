package hr.fer.zemris.java.tecaj.hw5.db;

import hr.fer.zemris.java.tecaj.hw5.collections.SimpleHashtable;
import hr.fer.zemris.java.tecaj.hw5.db.comparison.*;
import hr.fer.zemris.java.tecaj.hw5.db.conditional.CompositeConditional;
import hr.fer.zemris.java.tecaj.hw5.db.conditional.ConditionalExpression;
import hr.fer.zemris.java.tecaj.hw5.db.fieldValueGetters.FirstNameFieldGetter;
import hr.fer.zemris.java.tecaj.hw5.db.fieldValueGetters.IFieldValueGetter;
import hr.fer.zemris.java.tecaj.hw5.db.fieldValueGetters.JmbagFieldGetter;
import hr.fer.zemris.java.tecaj.hw5.db.fieldValueGetters.LastNameFieldGetter;
import hr.fer.zemris.java.tecaj.hw5.db.lexer.Lexer;
import hr.fer.zemris.java.tecaj.hw5.db.lexer.LexerException;
import hr.fer.zemris.java.tecaj.hw5.db.lexer.Token;
import hr.fer.zemris.java.tecaj.hw5.db.lexer.TokenType;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by akarlovic on 8.2.2017..
 */
public class StudentDatabase {
    private SimpleHashtable<String, StudentRecord>  students;

    StudentDatabase(List<String> students){
        this.students = new SimpleHashtable<>();
        Iterator<String> it = students.iterator();
        while(it.hasNext()){
            String student = it.next();
            String[] studentData = student.split("\\s");
            this.students.put(studentData[0], new StudentRecord(studentData));
        }
    }

    public StudentRecord forJMBAG(String jmbag){
        return students.get((Object)(jmbag));
    }

    public List<StudentRecord> filter(QueryFilter filter) {
        List<StudentRecord> studentList = new ArrayList<>();
        for (SimpleHashtable.TableEntry<String, StudentRecord> student : students) {
            if (filter.accepts((StudentRecord)student.getValue())){
                studentList.add((StudentRecord)student.getValue());
            }
        }
        return studentList;
    }

    public static void main(String[] args) throws IOException{
        // ucitaj studente
        List<String> lines = Files.readAllLines(
                Paths.get("D:\\IntelliJ Workspace\\cupic\\src\\hr\\fer\\zemris\\java\\tecaj\\hw5\\db\\database.txt"),
                StandardCharsets.UTF_8 );

        StudentDatabase database = new StudentDatabase(lines);

        QueryReader reader = new QueryReader();
        // ucitavaj naredbe
        reader.ucitaj(database);
    }
}
