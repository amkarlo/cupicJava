package hr.fer.zemris.java.tecaj.hw5.collections;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by akarlovic on 7.2.2017..
 */
public class SimpleHashtable<K,V> implements Iterable<SimpleHashtable.TableEntry<K,V>> {
    private int size;
    private int capacity;
    private int modificationCount;
    TableEntry<K,V>[] table;

    public SimpleHashtable(){
        this(16);
    }

    public SimpleHashtable(int capacity){
        if (capacity == 0)
            throw new IllegalArgumentException("Capacity can't be null");

        if ((capacity & (capacity -1)) != 0)
        {
            int residue = capacity % 2;
            int left = capacity - residue;
            int right = left * 2;
            if ((capacity-left) < (right-capacity)){
                capacity = left;
            }
            else
                capacity = right;
        }

        this.capacity = capacity;
        table = new TableEntry[capacity];
        size = 0;
    }

    public static class TableEntry<K,V> {
        private K key;
        private V value;
        private TableEntry next;

        TableEntry(K key, V value){
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public Object getKey(){ return key; }

        public Object getValue(){ return value; }

        public void setValue(Object value){ this.value = (V)value; }

        public String toString(){ return (String.valueOf(key) + "=" + String.valueOf(value)); }
    }

    private class IteratorImpl implements Iterator<SimpleHashtable.TableEntry<K,V>> {
        private SimpleHashtable.TableEntry pointer;
        private SimpleHashtable.TableEntry prev;
        private int itModCount;
        int tablePos;
        int position;

        IteratorImpl(){
            tablePos = -1;
            position = 0;
            itModCount = modificationCount;
        }

        private void computeNext() {
            if (size == 0)
                pointer = null;

            if (tablePos == -1) {
                tablePos = 0;
                prev = table[tablePos];
                pointer = prev;
                return;
            }

            if (pointer.next != null){
                prev = pointer;
                pointer = pointer.next;
                return;
            }

            ++tablePos;
            while(tablePos < capacity && table[tablePos] == null){
                ++tablePos;
            }

            if (tablePos >= capacity){
                pointer = null;
                return;
            }

            prev = table[tablePos];
            pointer = prev;
            return;
        }

        public boolean hasNext() {
            if(itModCount != modificationCount)
                throw new ConcurrentModificationException();
            if (position < (size-1))
                return true;
            return false;
        }

        public SimpleHashtable.TableEntry next() {
            if(itModCount != modificationCount)
                throw new ConcurrentModificationException();
            computeNext();
            if (pointer == null)
                throw new NoSuchElementException();
            ++position;
            return pointer;
        }

        public void remove() {
            if(itModCount != modificationCount)
                throw new ConcurrentModificationException();
            if (prev == null)
                throw new IllegalStateException("Can't remove.");
            --size;
            ++modificationCount;
            ++itModCount;
            if (prev == pointer){
                table[tablePos] = pointer.next;
                prev = null;
                return;
            }
            prev.next = pointer.next;
            prev = null;
        }
    }

    @Override
    public Iterator<TableEntry<K, V>> iterator() {
        return new IteratorImpl();
    }

    private TableEntry getIterator(Object key){
        if (key == null)
            throw new IllegalArgumentException("Key value cannot be null.");
        int hash = Math.abs(key.hashCode()) % capacity;
        TableEntry iterator = table[hash];
        return iterator;
    }

    private void resize(){
        TableEntry[] aux = new TableEntry[capacity*2];

        for (int i=0; i < capacity; ++i) {
            TableEntry iterator = table[i];
            while (iterator != null) {
                int hash = Math.abs(iterator.getKey().hashCode()) % (2*capacity);
                TableEntry it = aux[hash];

                if (it == null)
                    aux[hash] = new TableEntry(iterator.getKey(), iterator.getValue());
                else {
                    while(it.next != null){
                        it = it.next;
                    }
                    it.next = new TableEntry(iterator.getKey(), iterator.getValue());
                }
                iterator = iterator.next;
            }
        }
        table = aux;
        capacity *= 2;
    }

    public void put(K key, V value){
        TableEntry iterator = getIterator(key);

        if (iterator == null) {
            table[Math.abs(key.hashCode()) % capacity] = new TableEntry(key, value);
            ++size;
            ++modificationCount;
            return;
        }
        if (containsKey(key)) {
            while (iterator != null){
                if (key.equals(iterator.getKey())){
                    iterator.setValue(value);
                    return;
                }
                iterator = iterator.next;
            }
        }
        if (size > (0.75 * capacity)) {
            resize();
            iterator = getIterator(key);
        }
        if (iterator == null)
            iterator = new TableEntry(key, value);
        else{
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = new TableEntry(key, value);
        }

        ++size;
        ++modificationCount;
    }

    public V get(Object key){
        TableEntry iterator = getIterator(key);
        while(iterator != null){
            if (key.equals(iterator.key)){
                return (V)iterator.getValue();
            }
            iterator = iterator.next;
        }
        return null;
    }

    public int size(){
        return size;
    }

    public boolean containsKey(Object key){
        if (key == null) return false;
        TableEntry iterator = getIterator(key);
        while(iterator != null){
            if (key.equals(iterator.getKey()))
                return true;
            iterator = iterator.next;
        }
        return false;
    }

    public boolean containsValue(Object value){
        for (int i=0; i < capacity; ++i) {
            TableEntry iterator = table[i];
            while (iterator != null) {
                if (value.equals(iterator.getValue())) {
                    return true;
                }
                iterator = iterator.next;
            }
        }
        return false;
    }

    public void remove(Object key){
        ++modificationCount;
        TableEntry iterator = getIterator(key);
        if (key.equals(iterator.getKey())){
            table[Math.abs(key.hashCode()) % capacity] = iterator.next;
        }
        while(iterator.next != null){
            if (key.equals(iterator.next.getKey())){
                iterator.next = iterator.next.next;
                break;
            }
            iterator = iterator.next;
        }
        --size;
    }

    public boolean isEmpty(){
        if (size == 0)
            return true;
        return false;
    }

    public String toString(){
        String hashMap = "[";
        for (int i=0; i < capacity; ++i) {
            TableEntry iterator = table[i];
            while (iterator != null) {
                hashMap += iterator.toString() + ", ";
                iterator = iterator.next;
            }
        }
        hashMap = hashMap.substring(0,hashMap.length()-2);
        hashMap += "]";
        return hashMap;
    }

    public void clear(){
        for (int i=0; i < capacity; ++i) {
            table[i] = null;
        }
        size = 0;
        ++modificationCount;
    }
}
