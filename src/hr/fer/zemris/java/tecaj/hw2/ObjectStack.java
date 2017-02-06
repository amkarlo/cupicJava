package hr.fer.zemris.java.tecaj.hw2;

/**
 * Created by akarlovic on 18.1.2017..
 */
public class ObjectStack {
    ArrayIndexedCollection indexedCollection;

    public ObjectStack(){
        this.indexedCollection = new ArrayIndexedCollection();
    }

    public boolean isEmpty(){
        if (this.size() == 0)
            return true;
        else
            return false;
    }
    public int size(){
        return this.indexedCollection.size();
    }

    public void push(Object value){
        indexedCollection.add(value);
    }
    public Object pop(){
        if (indexedCollection.size() == 0)
            throw new EmptyStackException("Stack is empty");
        Object value = indexedCollection.get(size()-1);
        indexedCollection.remove(size()-1);
        return value;
    }
    public Object peek(){
        if (indexedCollection.size() == 0)
            throw new EmptyStackException("Stack is empty");
        return indexedCollection.get(size()-1);
    }
    public void clear(){
        indexedCollection.clear();
    }
}
