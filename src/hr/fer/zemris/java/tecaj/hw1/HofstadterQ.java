package hr.fer.zemris.java.tecaj.hw1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by akarlovic on 16.1.2017..
 */
public class HofstadterQ {

    public static int racunaj(int broj){
        if (broj == 1 || broj == 2)
            return 1;
        return (racunaj(broj - racunaj(broj -1)) + racunaj(broj - racunaj(broj - 2)));
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter a number");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new BufferedInputStream(System.in))    );
        String input = reader.readLine();
        int broj;
        if(input != null) {
            if (!input.isEmpty()) {
                broj = Integer.parseInt(input);
                if (broj < 0)
                    System.out.println("Number not positive");
                else
                    System.out.println("You requested calculation of " + input +
                       " number of Hofstadter's Q-sequence. The requested number is " +
                            Integer.toString(racunaj(broj)));
            }
        }
    }

}