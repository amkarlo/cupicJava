package hr.fer.zemris.java.tecaj.hw5.collections;

/**
 * Created by akarlovic on 7.2.2017..
 */
public class SimpleHashtable<K,V> {
    private int size;
    private int capacity;
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

    private TableEntry getIterator(Object key){
        if (key == null)
            throw new IllegalArgumentException("Key value cannot be null.");
        int hash = Math.abs(key.hashCode()) % capacity;
        TableEntry iterator = table[hash];
        return iterator;
    }

    public void put(K key, V value){
        TableEntry iterator = getIterator(key);

        if (iterator == null)
        {
            table[Math.abs(key.hashCode()) % capacity] = new TableEntry(key, value);
            ++size;
            return;
        }

        if (containsKey(key))
        {
            while (iterator != null){
                if (key.equals(iterator.getKey())){
                    iterator.setValue(value);
                    return;
                }
                iterator = iterator.next;
            }
        }
        while (iterator.next != null){
            iterator = iterator.next;
        }
        iterator.next = new TableEntry(key, value);
        ++size;
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
        TableEntry iterator = getIterator(key);
        while(iterator.next != null){
            if (key.equals(iterator.next.getKey())){
                iterator.next = iterator.next.next;
            }
            iterator = iterator.next;
        }
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
}
