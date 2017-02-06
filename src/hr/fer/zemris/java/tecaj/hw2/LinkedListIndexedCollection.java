package hr.fer.zemris.java.tecaj.hw2;

/**
 * Created by akarlovic on 17.1.2017..
 */
public class LinkedListIndexedCollection extends Collection {
    private static class ListNode{
        Object value;
        ListNode previous;
        ListNode next;
    }
    int size;
    ListNode first;
    ListNode last;

    LinkedListIndexedCollection(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    LinkedListIndexedCollection(Collection other){
        this.addAll(other);
    }
    @Override
    int size(){
        return size;
    }
    @Override
    void add(Object value){
        if (value == null)
            throw new IllegalArgumentException("add: Object is null");
        if (this.first == null){
            this.first = new ListNode();
            this.last = new ListNode();
            this.first.value = new Object();
            this.first.value = value;
            this.last = this.first;
        }
        else{
            ListNode novi = new ListNode();
            novi.value = value;
            novi.previous = this.last;
            this.last.next = novi;
            this.last = novi;
        }
        ++this.size;
    }
    Object get(int index){
        if (index >=0 && index < this.size){
            ListNode tmp;
            if (index < (size/2)){
                tmp = this.first;
                while(index > 0){
                    tmp = tmp.next;
                    --index;
                }
            }
            else{
                tmp = this.last;
                while((this.size - index) > 0){
                    tmp = tmp.previous;
                    ++index;
                }
            }
            return tmp.value;
        }
        else
            throw new IndexOutOfBoundsException("get: Index too large");
    }
    void insert(Object value, int position){
        if (value == null)
            throw new IllegalArgumentException("insert: Object is null");
        if ( position < 0 || position > this.size)
            throw new IndexOutOfBoundsException("insert: Index not between 0 an size");
        ListNode tmp = this.first;
        if (position == this.size) {
            this.add(value);
        }
        else{
            ListNode newNode = new ListNode();
            newNode.value = value;
            while(position > 0){
                tmp = tmp.next;
                --position;
            }
            newNode.next = tmp;
            newNode.previous = tmp.previous;
            tmp.previous= newNode;
        }
    }
    @Override
    boolean contains(Object value){
        if (value == null)
            throw new IllegalArgumentException("contains: Object is null");
        ListNode tmp = this.first;
        while (tmp != null){
            if (value.equals(tmp.value)){
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }
    int indexOf(Object value){
        if (value == null)
            throw new IllegalArgumentException("indexOf: Object is null");
        int i = 0;
        ListNode tmp = this.first;
        while(tmp != null){
            if(value.equals(tmp.value))
                return i;
            else
                ++i;
        }
        return  -1;
    }
    void remove(int index){
        if (index < 0 && index > (size-1))
            throw new IndexOutOfBoundsException("remove: Index not between 0 and size-1");
        ListNode tmp = this.first;
        while(index > 0){
            tmp = tmp.next;
            --index;
        }
        if (tmp.previous != null)
            tmp.previous.next = tmp.next;
        if (tmp.next != null)
            tmp.next.previous = tmp.previous;
        --this.size;

    }
    @Override
    boolean remove(Object value){
        if (value == null)
            throw new IllegalArgumentException("add: Object is null");
        ListNode tmp = this.first;
        while (tmp != null){
            if (value.equals(tmp.value)){
                if (tmp.previous != null)
                    tmp.previous.next = tmp.next;
                if (tmp.next != null)
                    tmp.next.previous = tmp.previous;
                --this.size;
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }
    @Override
    Object[] toArray(){
        try {
            Object[] newArray = new Object[this.size];
            ListNode tmp = this.first;
            for (int i = 0; i < this.size; i++) {
                newArray[i] = tmp.value;
                tmp = tmp.next;
            }
            return newArray;
        }
        catch(UnsupportedOperationException e){
            System.err.println("toArray: Caught UnsupportedOperationException: " + e.getMessage());
        }
        return null;
    }
    @Override
    void forEach(Processor processor){
        ListNode tmp = this.first;
        while (tmp.next != null){
            processor.process(tmp.value);
            tmp = tmp.next;
        }
    }
    @Override
    void addAll(Collection other){
        Object[] tmp = other.toArray();
        for (int i=0; i < tmp.length; i++){
            this.add(tmp[i]);
        }
    }
    @Override
    void clear(){
        this.first = null;
        this.last = null;
    }

}
