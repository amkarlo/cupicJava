package hr.fer.zemris.java.tecaj.hw5.db;

/**
 * Created by akarlovic on 8.2.2017..
 */
public class StudentRecord {
    private String jmbag;
    private String lastName;
    private String firstName;
    private int finalGrade;

    StudentRecord(String[] data){
        this.jmbag = data[0];
        this.lastName = data[1];
        this.firstName = data[2];
        this.finalGrade = Integer.parseInt(data[3]);
    }
}
