package hr.fer.zemris.java.tecaj.hw1;

/**
 * Created by akarlovic on 16.1.2017..
 */
public class NumberDecomposition {

    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        int prost = 2;

        while(num > 1){
            while (num%prost == 0) {
                num = num / prost;
                System.out.println(prost);
            }
            prost = PrimeNumbers.nadjiProst(prost + 1);
        }
    }
}
