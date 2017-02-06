package hr.fer.zemris.java.tecaj.hw2.Demo;

import hr.fer.zemris.java.tecaj.hw2.ObjectStack;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by akarlovic on 18.1.2017..
 */
public class StackDemo {
    static int izracunaj(int b1, int b2, String znak){
        if (znak.equals("+")){
            return b1 + b2;
        }
        else
            if (znak.equals("-")){
                return  b1 - b2;
            }
            else
                if (znak.equals("/")){
                    if (b2 == 0)
                        throw new IllegalArgumentException("Dijeljenje nulom nije dozvoljeno!");
                    return b1 / b2;
                }else
                    if (znak.equals("*")){
                        return  b1 * b2;
                    }
                    else
                        return b1 % b2;
    }
    public static void main(String[] args) throws IOException {
        ObjectStack stog = new ObjectStack();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new BufferedInputStream(System.in))    );
        String input = reader.readLine();

        if(input != null) {
            String[] inputArray = input.split("\\s", 0);
            for (int i=0; i < inputArray.length; i++){
                String znak = inputArray[i];
                if (znak.matches("-?[0-9]"))
                    stog.push(Integer.parseInt(znak));
                else
                    if (znak.matches("[+-/*%]")){
                    int broj2 = (Integer) stog.pop();
                    int broj1 = (Integer) stog.pop();
                    int rezultat = izracunaj(broj1, broj2, znak);
                    stog.push(rezultat);
                    }
                    else
                        throw new IllegalArgumentException("Nedozvoljeni znak: " + znak);
            }
            if (stog.size() != 1)
                throw new IllegalArgumentException("Izraz nije ispravan: " + input);
            System.out.println(stog.peek());
        }
    }
}