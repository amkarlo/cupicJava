package hr.fer.zemris.java.tecaj.hw1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static int ucitaj(String poruka) throws IOException {
        System.out.println("Please provide " + poruka);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new BufferedInputStream(System.in))    );
        String input = reader.readLine();
        int number;
        while(input != null) {
            if (input.isEmpty()) {
                System.out.println("Nothing was given.");
                break;
            }
            number = Integer.parseInt(input);
            if (number <= 0) {
                System.out.println(poruka + " is negative.");
                break;
            }
            else
                return number;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        int width = ucitaj("Width");
        int height = ucitaj("Height");

        System.out.println("You have specified a rectangle with width " +  Integer.toString(width) +
                " and height " + Integer.toString(height) + ". Its area is " +
                Integer.toString(width*height) + " and its perimeter is " + Integer.toString(2*width + 2* height));
    }
}
