package hr.fer.zemris.java.tecaj.hw5.collections;

/**
 * Created by akarlovic on 7.2.2017..
 */
public class TableEntry<K,V> {
    K key;
    V value;
    TableEntry next;

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
