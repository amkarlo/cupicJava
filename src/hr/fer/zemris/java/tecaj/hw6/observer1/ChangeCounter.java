package hr.fer.zemris.java.tecaj.hw6.observer1;

/**
 * Created by akarlovic on 13.2.2017..
 */
public class ChangeCounter implements IntegerStorageObserver {
    private int counter;

    public ChangeCounter() {
        counter = 0;
    }

    @Override
    public void valueChanged(IntegerStorage istorage) {
        ++counter;
        System.out.println("Number of value changes since tracking: " + String.valueOf(counter));
    }
}
