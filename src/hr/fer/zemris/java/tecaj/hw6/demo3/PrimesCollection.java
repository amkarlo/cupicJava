package hr.fer.zemris.java.tecaj.hw6.demo3;

import java.util.Iterator;

/**
 * Created by akarlovic on 13.2.2017..
 */
public class PrimesCollection implements Iterable<Integer> {
    private int numberOfPrimes;

    PrimesCollection(int number){
        numberOfPrimes = number;
    }

    private static boolean jeliProst(int broj){
        for (int i=2; i < (broj / 2 + 1); i++){
            if (broj%i == 0)
                return false;
        }
        return true;
    }

    private static int nadjiProst(int pocetni){
        while(!jeliProst(pocetni)){
            pocetni = pocetni + 1;
        }
        return pocetni;
    }

    private class IteratorImpl implements Iterator<Integer> {
        private int index;
        private int prost;

        IteratorImpl(){
            index = 0;
            prost = 1;
        }

        @Override
        public boolean hasNext() {
            if (index < numberOfPrimes)
                return true;
            return false;
        }

        @Override
        public Integer next() {
            ++index;
            prost = nadjiProst(prost + 1);
            return prost;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IteratorImpl();
    }
}
