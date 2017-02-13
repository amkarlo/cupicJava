package hr.fer.zemris.java.tecaj.hw6.observer2;

/**
 * Created by akarlovic on 13.2.2017..
 */
public class IntegerStorageChange {
    private IntegerStorage storage;
    private int oldValue;
    private int newValue;

    IntegerStorageChange(IntegerStorage storage, int newValue){
        this.storage = storage;
        this.oldValue = storage.getValue();
        this.newValue = newValue;
    }

    public int getValue(){
        return newValue;
    }

    public int getOldValue(){
        return oldValue;
    }

    public IntegerStorage getStorage(){
        return storage;
    }

}
