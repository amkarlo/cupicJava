package hr.fer.zemris.java.tecaj.hw6.demo5;

import hr.fer.zemris.java.tecaj.hw6.demo5.StudentRecord;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
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

        List<StudentRecord> odlikasiSortirano = records.stream()
                                .filter(studentRecord -> studentRecord.getOcjena() == 5)
                                .sorted((e1, e2) -> Double.compare(
                                            (e1.getMedjuispit() + e1.getZavrsni() + e1.getVjezbe()),
                                            (e2.getMedjuispit() + e2.getZavrsni() + e2.getVjezbe())))
                                .collect(Collectors.toList());

        for (StudentRecord student : odlikasiSortirano) {
            System.out.println(student.toString());
        }
        System.out.println();

        List<String> nepolozeniJMBAGovi = records.stream()
                                        .filter(studentRecord -> studentRecord.getOcjena() == 1)
                                        .sorted((e1, e2) -> Integer.compare(Integer.parseInt(e1.getJmbag()), Integer.parseInt(e2.getJmbag())))
                                        .map(studentRecord -> studentRecord.getJmbag())
                                        .collect(Collectors.toList());

//        for (String jmbag : nepolozeniJMBAGovi) {
//            System.out.println(jmbag);
//        }
        System.out.println(String.valueOf(nepolozeniJMBAGovi.size()));
        System.out.println();

        Map<Integer, List<StudentRecord>> mapaPoOcjenama = records.stream()
                                                .collect(Collectors.groupingBy(StudentRecord::getOcjena));

//        for (Map.Entry<Integer, List<StudentRecord>> entry : mapaPoOcjenama.entrySet())
//        {
//            System.out.print(entry.getKey() + ": [");
//            List<StudentRecord> students = entry.getValue();
//            for (StudentRecord student : students){
//                if (students.indexOf(student) == (students.size()-1))
//                    System.out.println(student.getJmbag() + "]");
//                else
//                    System.out.print(student.getJmbag() + ",");
//            }
//        }

        System.out.println();

//        Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
//                Function<? super T, ? extends U> valueMapper,
//                BinaryOperator<U> mergeFunction)
        Map<Integer, Integer> mapaPoOcjenama2 = records.stream()
                                  .collect(Collectors.toMap(StudentRecord::getOcjena, s -> 1, (s, a) -> ++s
                                  ));

        for (Map.Entry<Integer, Integer> entry : mapaPoOcjenama2.entrySet())
        {
            System.out.println(String.valueOf(entry.getKey()) + " : " + String.valueOf(entry.getValue()));
        }
        System.out.println();

        Map<Boolean, List<StudentRecord>> prolazNeprolaz = records.stream()
                                    .collect(Collectors.partitioningBy(s -> s.getOcjena() > 1));

        for (Map.Entry<Boolean, List<StudentRecord>> entry : prolazNeprolaz.entrySet())
        {
            System.out.println(entry.getKey() + " : " + String.valueOf(entry.getValue().size()));;
        }
        System.out.println();
    }
}
