package hr.fer.zemris.java.tecaj.hw6.observer2;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by akarlovic on 13.2.2017..
 */
public class IntegerStorage {
    private int value;
    private List<IntegerStorageObserver> observers;

    public IntegerStorage(int initialValue) {
        this.value = initialValue;
        this.observers = new CopyOnWriteArrayList<>();
    }
    public void addObserver(IntegerStorageObserver observer) {
        // add the observer in observers if not already there ...
        if (!observers.contains(observer)){
            observers.add(observer);
        }
    }
    public void removeObserver(IntegerStorageObserver observer) {
        // remove the observer from observers if present ...
        if (observers.contains(observer)){
            observers.remove(observer);
        }
    }
    public void clearObservers() {
        // remove all observers from observers list ...
        observers.clear();
    }
    public int getValue() { return value; }

    public void setValue(int value) {
        if (this.value != value) {
            IntegerStorageChange storageChange = new IntegerStorageChange(this, value);
            this.value = value;
            if(observers != null) {
                for(IntegerStorageObserver observer : observers) {
                    observer.valueChanged(storageChange);
                }
            }
        }
    }

}
