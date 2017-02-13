package hr.fer.zemris.java.tecaj.hw6.observer2;

/**
 * Created by akarlovic on 13.2.2017..
 */
public class SquareValue implements IntegerStorageObserver {
    @Override
    public void valueChanged(IntegerStorageChange istorage) {
        int value = istorage.getValue();
        System.out.println("Provided new value: " + String.valueOf(value) + ", square is " + String.valueOf(value*value));
    }
}
