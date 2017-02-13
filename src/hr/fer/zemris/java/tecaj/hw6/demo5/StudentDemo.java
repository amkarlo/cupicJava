package hr.fer.zemris.java.tecaj.hw6.demo5;

import hr.fer.zemris.java.tecaj.hw6.demo5.StudentRecord;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by akarlovic on 13.2.2017..
 */
public class StudentDemo {

    public static List<StudentRecord> convert(List<String> lines){
        List<StudentRecord> students = new ArrayList<>();
        for (String line : lines){
            String[] data = line.split("\\s");
            students.add(new StudentRecord(data));
        }
        return students;
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(
                Paths.get("D:\\IntelliJ Workspace\\cupic\\src\\hr\\fer\\zemris\\java\\tecaj\\hw6\\demo5\\studenti.txt"),
                StandardCharsets.UTF_8 );

        List<StudentRecord> records = convert(lines);

        long broj = records.stream()
                .filter(studentRecord -> (studentRecord.getMedjuispit() + studentRecord.getZavrsni() + studentRecord.getVjezbe()) > 25)
                .count();
        System.out.println(String.valueOf(broj));
        System.out.println();

        long broj5 = records.stream()
                .filter(studentRecord -> studentRecord.getOcjena() == 5)
                .count();
        System.out.println(String.valueOf(broj5));
        System.out.println();

        List<StudentRecord> odlikasi = records.stream()
                                .filter(studentRecord -> studentRecord.getOcjena() == 5)
                                .collect(Collectors.toList());
        for (StudentRecord student : odlikasi) {
            System.out.println(student.toString());
        }
        System.out.println();

        Comparator<StudentRecord> poBrojuBodova = (e1, e2) -> Double.compare(
                (e1.getMedjuispit() + e1.getZavrsni() + e1.getVjezbe()),
                (e2.getMedjuispit() + e2.getZavrsni() + e2.getVjezbe()));
        List<StudentRecord> odlikasiSortirano = records.stream()
                                .filter(studentRecord -> studentRecord.getOcjena() == 5)
                                .sorted(poBrojuBodova)
                                .collect(Collectors.toList());
    }
}
