package hr.fer.zemris.java.tecaj.hw6.demo5;

/**
 * Created by akarlovic on 13.2.2017..
 */
public class StudentRecord {
    private String jmbag;
    private String prezime;
    private String ime;
    private double medjuispit;
    private double zavrsni;
    private double vjezbe;
    private int ocjena;

    public StudentRecord(String... data){
        jmbag = (String)data[0];
        prezime = (String)data[1];
        ime = (String)data[2];
        medjuispit = Double.parseDouble(data[3]);
        zavrsni = Double.parseDouble(data[4]);
        vjezbe = Double.parseDouble(data[5]);
        ocjena = Integer.parseInt(data[6]);
    }

    public String getJmbag() {
        return jmbag;
    }

    public void setJmbag(String jmbag) {
        this.jmbag = jmbag;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public double getMedjuispit() {
        return medjuispit;
    }

    public void setMedjuispit(double medjuispit) {
        this.medjuispit = medjuispit;
    }

    public double getZavrsni() {
        return zavrsni;
    }

    public void setZavrsni(double zavrsni) {
        this.zavrsni = zavrsni;
    }

    public double getVjezbe() {
        return vjezbe;
    }

    public void setVjezbe(double vjezbe) {
        this.vjezbe = vjezbe;
    }

    public int getOcjena() {
        return ocjena;
    }

    public void setOcjena(int ocjena) {
        this.ocjena = ocjena;
    }

    public String toString(){
        String student = "";
        student = jmbag + ", " + prezime + ", " + ime + ", " + String.valueOf(medjuispit) + ", " + String.valueOf(zavrsni)
                + ", " + String.valueOf(vjezbe) + ", " + String.valueOf(ocjena);
        return student;
    }

}
