package hr.fer.zemris.java.tecaj.hw6.demo3;

/**
 * Created by akarlovic on 13.2.2017..
 */
public class PrimesDemo1 {
    public static void main(String[] args){
        PrimesCollection primesCollection = new PrimesCollection(5);// 5: how many of them
        for(Integer prime : primesCollection) {
            System.out.println("Got prime: "+prime);
        }

    }
}
