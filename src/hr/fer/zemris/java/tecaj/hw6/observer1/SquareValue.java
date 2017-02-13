package hr.fer.zemris.java.tecaj.hw5.hw6.observer1;

/**
 * Created by akarlovic on 13.2.2017..
 */
public class SquareValue implements IntegerStorageObserver {
    @Override
    public void valueChanged(IntegerStorage istorage) {
        int value = istorage.getValue();
        System.out.println("Provided new value: " + String.valueOf(value) + ", square is " + String.valueOf(value*value));
    }
}
