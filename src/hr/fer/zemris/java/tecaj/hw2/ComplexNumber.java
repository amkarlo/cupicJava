package hr.fer.zemris.java.tecaj.hw2;

import sun.misc.FloatingDecimal;

import java.lang.Math;
/**
 * Created by akarlovic on 18.1.2017..
 */
public class ComplexNumber {
    double real;
    double imaginary;
    double magnitude;
    double angle;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
        this.magnitude = Math.hypot(real, imaginary);
        this.angle = Math.atan(imaginary / real);
    }

    public static ComplexNumber fromReal(double real) {
        return new ComplexNumber(real, 0);
    }

    public static ComplexNumber fromImaginary(double imaginary) {
        return new ComplexNumber(0, imaginary);
    }

    public static ComplexNumber fromMagnitudeAndAngle(double magnitude, double angle) {
        return new ComplexNumber(
                magnitude * Math.cos(angle), magnitude * Math.sin(angle));

    }
    public static ComplexNumber parse(String s){
        double a = 0;
        double b = 0;
        String[] niz = s.split("[-?+?]", 0);
        for (int i=0; i < niz.length; i++){
            if (!niz[i].equals("")){
                if (niz[i].matches(".*[i]+")){
                    if (niz[i].length() == 1)
                        b = 1;
                    else
                        try{
                            b = Double.parseDouble(niz[i].substring(0, niz[i].length()-1));
                        }
                        catch (NumberFormatException e){
                            System.err.println("parse: Nepodržani znakovi: " + e.getMessage());
                        }
                    if (!s.equals(niz[i]) && (s.charAt(s.length()-niz[i].length()-1) == '-'))
                        b *= -1;
                }
                else {
                    try{
                        a = Double.parseDouble(niz[i]);
                    }
                    catch (NumberFormatException e){
                        System.err.println("parse: Nepodržani znakovi: " + e.getMessage());
                    }
                    if (s.charAt(0) == '-')
                        a *= -1;
                }
            }
        }
        return new ComplexNumber(a,b);
    }

    public double getReal() {
        return this.real;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public double getAngle() {
        return angle;
    }

    public ComplexNumber add(ComplexNumber C) {
        return new ComplexNumber(this.real + C.getReal(), this.imaginary + C.getImaginary());
    }

    public ComplexNumber sub(ComplexNumber C) {
        return new ComplexNumber(this.real - C.getReal(), this.imaginary - C.getImaginary());
    }

    public ComplexNumber mul(ComplexNumber C) {
        double r = this.magnitude * C.getMagnitude();
        double a = r * Math.cos(this.angle + C.getAngle());
        double b = r * Math.sin(this.angle + C.getAngle());
        return new ComplexNumber(a, b);
    }

    public ComplexNumber div(ComplexNumber C) {
        double r = this.magnitude / C.getMagnitude();
        double a = r * Math.cos(this.angle - C.getAngle());
        double b = r * Math.sin(this.angle - C.getAngle());
        return new ComplexNumber(a, b);
    }

    public ComplexNumber power(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Eksponent mora biti veći ili jednak 0");
        double a = Math.pow(this.magnitude, n) * Math.cos(n * this.angle);
        double b = Math.pow(this.magnitude, n) * Math.sin(n * this.angle);
        return new ComplexNumber(a, b);
    }

    public ComplexNumber[] root(int n) {
        if (n < 1)
            throw new IllegalArgumentException("Eksponent mora biti strogo veći od 0");
        double r = Math.pow(this.magnitude, 1 / n);
        ComplexNumber[] korijeni = new ComplexNumber[n];
        for (int i = 0; i < n; i++) {
            double a = r * Math.cos((this.angle + 2 * i * Math.PI) / n);
            double b = r * Math.sin((this.angle + 2 * i * Math.PI) / n);
            korijeni[i] = new ComplexNumber(a, b);
        }
        return korijeni;
    }

    public String toString() {
        String broj = String.valueOf(this.real);
        if (this.imaginary < 0)
            broj += " - " + String.valueOf(Math.abs(this.imaginary)) + "i";
        else
            broj += " + " + String.valueOf(this.imaginary) + "i";
        return broj;
    }

    public static void main(String[] args) {
        System.out.println(parse("-2.5+3i").toString());
        System.out.println(parse("2").toString());
        System.out.println(parse("3i").toString());
        System.out.println(parse("-6i").toString());
        System.out.println(parse("i").toString());
        System.out.println(parse("5-7i").toString());
        System.out.println(parse("2-i").toString());
        System.out.println(parse("-i").toString());
        System.out.println(parse("j+i").toString());
        ComplexNumber c1 = new ComplexNumber(2, 3);
        ComplexNumber c2 = parse("2.5-3i");
        ComplexNumber c3 = c1.add(ComplexNumber.fromMagnitudeAndAngle(2, 1.57)).div(c2).power(3).root(2)[1];
        System.out.println(c3.toString());
    }
}