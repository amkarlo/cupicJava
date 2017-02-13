package hr.fer.zemris.java.tecaj.hw5.hw6.observer1;

import java.util.ArrayList;
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
        // Only if new value is different than the current value:
        if (this.value != value) {
            // Update current value
            this.value = value;
            // Notify all registered observers
            if(observers != null) {
                for(IntegerStorageObserver observer : observers) {
                    observer.valueChanged(this);
                }
            }
        }
    }

}
