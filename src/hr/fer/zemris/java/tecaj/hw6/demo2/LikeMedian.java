package hr.fer.zemris.java.tecaj.hw6.demo2;

import java.util.*;

/**
 * Created by akarlovic on 13.2.2017..
 */
public class LikeMedian<E> implements Iterable<E>{
    private List<E> elements;

    LikeMedian(){ elements = new ArrayList<E>(); }

    public void add(E value){
        elements.add(value);
    }

    private class IteratorImpl implements Iterator<E> {
        ListIterator iterator;

        IteratorImpl(){
            iterator = elements.listIterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public E next() {
            return (E)iterator.next();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    private Optional<E> getMedian(){
        E median;

        E[] elementsArray = (E[])elements.toArray();
        Arrays.sort(elementsArray);

        if (elementsArray.length % 2 == 0)
            median = elementsArray[(elementsArray.length-1)/2];
        else
            median = elementsArray[elementsArray.length/2];

        return Optional.of(median);
    }

    public Optional<E> get(){
        try {
            if (Class.forName("java.lang.Comparable").isInstance(elements))
                return Optional.empty();
            else
                return getMedian();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

}
