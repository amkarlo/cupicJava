package hr.fer.zemris.java.tecaj.hw2;

/**
 * Created by akarlovic on 17.1.2017..
 */
public class Collection {
    boolean isEmpty(){
        if (this.size() == 0)
            return true;
        else
            return false;
    }

    int size(){
        return  0;
    }

    void add(Object value){ }

    boolean contains(Object value) {
        return false;
    }

    boolean remove (Object value){
        return false;
    }

    Object[] toArray() throws UnsupportedOperationException{
        Object[] newArray = new Object[this.size()];
        return newArray;
    }

    void forEach(Processor processor){ }

    void addAll(Collection other){ }

    void clear () { }
}
