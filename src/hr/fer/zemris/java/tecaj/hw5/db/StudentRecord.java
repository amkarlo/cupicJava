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
        jmbag = data[0];
        lastName = data[1];
        firstName = data[2];
        finalGrade = Integer.parseInt(data[3]);
    }

    public String getJmbag() {
        return jmbag;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getFinalGrade() {
        return finalGrade;
    }

    public String toString(){
        String student = "";
        student = jmbag + " " + lastName + " " + firstName + " " + String.valueOf(finalGrade);
        return student;
    }
}
