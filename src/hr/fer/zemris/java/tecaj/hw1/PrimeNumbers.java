package hr.fer.zemris.java.tecaj.hw1;

/**
 * Created by akarlovic on 16.1.2017..
 */
public class PrimeNumbers {

    public static boolean jeliProst(int broj){
        for (int i=2; i < (broj / 2 + 1); i++){
            if (broj%i == 0)
                return false;
        }
        return true;
    }

    public static int nadjiProst(int pocetni){
        while(!jeliProst(pocetni)){
            pocetni = pocetni + 1;
        }
        return pocetni;
    }

    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        int prost = 2;

        for (int i=0; i < num; i++) {
            System.out.println(prost);
            prost = nadjiProst(prost + 1);
        }
    }
}
