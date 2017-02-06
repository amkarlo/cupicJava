package hr.fer.zemris.java.tecaj.hw1;

import java.lang.Math;

/**
 * Created by akarlovic on 16.1.2017..
 */
public class Roots {

    public static void main(String[] args)  {

        int real = Integer.parseInt(args[0]);
        int imaginary = Integer.parseInt((args[1]));
        int root = Integer.parseInt(args[2]);

        double r = Math.hypot(real, imaginary);
        double phi = Math.atan(imaginary/real);

        double radius = Math.pow(Math.E, Math.log(r)/root);

        for(int i=0; i < root; ++i){
            double x = Math.cos((phi + 2 * i * Math.PI) / root);
            double y = Math.sin((phi + 2 * i * Math.PI) / root);
            System.out.println(Math.round(radius * x) + " + " + Math.round(radius * y) + " i");
        }
    }
}
