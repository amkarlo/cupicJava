package hr.fer.zemris.java.tecaj.hw6.demo3;

/**
 * Created by akarlovic on 13.2.2017..
 */
public class PrimesDemo2 {
    public static void main(String[] args){
        PrimesCollection primesCollection = new PrimesCollection(2);
        for(Integer prime : primesCollection) {
            for(Integer prime2 : primesCollection) {
                System.out.println("Got prime pair: "+prime+", "+prime2);
            }
        }
    }
}
