package hr.fer.zemris.java.tecaj.hw2;

import java.util.Arrays;

/**
 * Created by akarlovic on 17.1.2017..
 */
public class ArrayIndexedCollection extends Collection {
    private int size;
    private int capacity;
    private Object[] elements;

    public ArrayIndexedCollection(int initialCapacity) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException(
                    "Capacity should be greater than 1.");
        this.size = 0;
        this.capacity = initialCapacity ;
        this.elements = new Object[capacity];
    }

    public ArrayIndexedCollection() {
        this(16);
    }

    public ArrayIndexedCollection(Collection other){
        this(other.size());
        this.addAll(other);
    }
    @Override
    public int size() {
        return size;
    }
    void doubleCapacity(){
        Object[] tmp = this.toArray();
        this.capacity *= 2;
        this.elements = new Object[this.capacity];
        for (int i=0; i < this.size; i++) {
            this.elements[i] = tmp[i];
        }
    }
    @Override
    public void add(Object value){
        if (value == null)
            throw new IllegalArgumentException("add: Object is null");
        for (int i=0; i < this.size; i++) {
            if (this.elements[i] == null) {
                this.elements[this.size++] = value;
                return;
            }
        }
        doubleCapacity();
        this.elements[this.size] = value;
        ++this.size;
    }
    public Object get(int index){
        if (index >=0 && index < this.size)
            return elements[index];
        else
            throw new IndexOutOfBoundsException("get: Index too large");
    }
    public void insert(Object value, int position){
        if (value == null)
            throw new IllegalArgumentException("add: Object is null");
        if ( position < 0 || position > this.size)
            throw new IndexOutOfBoundsException("insert: Index not between 0 and size");
        if (this.size == this.capacity)
            this.doubleCapacity();
        for (int i=this.size; i > position; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[position] = value;
        ++this.size;
    }
    @Override
    public boolean contains(Object value){
        if (value == null)
            throw new IllegalArgumentException("add: Object is null");
        for (int i=0; i < this.size; i++){
            if (value.equals((this.elements[i])))
                return true;
        }
        return  false;
    }
    public int indexOf(Object value){
        if (value == null)
            throw new IllegalArgumentException("add: Object is null");
        for (int i=0; i < this.size; i++){
            if (this.elements[i].equals((value)))
                return i;
        }
        return  -1;
    }
    public void remove(int index){
        if (index < 0 && index > (size-1))
            throw new IndexOutOfBoundsException("remove: Index not between 0 and size-1");
        --this.size;
        for(int k=index; k < this.size; k++){
            this.elements[k] = this.elements[k+1];
        }
    }
    @Override
    public boolean remove(Object value){
        if (value == null)
            throw new IllegalArgumentException("add: Object is null");
        for (int i=0; i < this.size; i++){
            if (this.elements[i].equals((value))) {
                --this.size;
                for (int j=i; j < this.size; j++)
                    this.elements[i] = this.elements[i+1];
                return true;
            }
        }
        return  false;
    }
    @Override
    Object[] toArray(){
        try{
            Object[] newArray = new Object[this.size];
            for (int i = 0; i < this.size; i++) {
                newArray[i] = this.elements[i];
            }
            return newArray;
        }
        catch(UnsupportedOperationException e){
            System.err.println("toArray: Caught UnsupportedOperationException: " + e.getMessage());
        }
       return null;
    }
    @Override
    public void forEach(Processor processor) {
        for (int i = 0; i < this.capacity; i++) {
            if (this.elements[i] != null)
                processor.process(this.elements[i]);
        }
    }
    @Override
    void addAll(Collection other){
        Object[] tmp = other.toArray();
        for (int i = 0; i < tmp.length; i++) {
            this.add(tmp[i]);
        }
    }
    @Override
    public void clear(){
        for (int i = 0; i < this.size; i++) {
            this.elements[i] = null;
        }
        this.size = 0;
    }

    public static void main(String[] args) {
        ArrayIndexedCollection col = new ArrayIndexedCollection(2);
        col.add(new Integer(20));
        col.add("New York");
        col.add("San Francisco");  // here the internal array is reallocated to 4
        System.out.println(col.contains("New York")); // writes: true
        col.remove(1); // removes "New York"; shifts "San Francisco" to position 1
        System.out.println(col.get(1)); // writes: "San Francisco"
        System.out.println(col.size()); // writes: 2
        col.add("Los Angeles");
        col.insert("Novi", 0);
        col.insert("drugi", 2);
        col.remove("drugi");
        col.insert("treci", 3);
        LinkedListIndexedCollection col2 = new LinkedListIndexedCollection(col);
        class P extends Processor {
            public void process(Object o) {
                System.out.println(o);  }
        };
        System.out.println("col1 elements:");
        col.forEach(new P());
        System.out.println("col1 elements again:");
        System.out.println(Arrays.toString(col.toArray()));
        System.out.println("col2 elements:");
        col2.forEach(new P());
        System.out.println("col2 elements again:");
        System.out.println(Arrays.toString(col2.toArray()));
        System.out.println(col.contains(col2.get(1))); // true
        System.out.println(col2.contains(col.get(1))); // true
        col.remove(new Integer(20)); // removes 20 from collection (at position 0)
    }
}
