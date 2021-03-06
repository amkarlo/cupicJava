package hr.fer.zemris.java.tecaj.hw6.observer1;

/**
 * Created by akarlovic on 13.2.2017..
 */
public class DoubleValue implements IntegerStorageObserver {
    private int counter;

    public DoubleValue(int counter){
        this.counter = counter;
    }
    @Override
    public void valueChanged(IntegerStorage istorage) {
        if (counter > 0) {
            --counter;
            System.out.println("Double value: " + String.valueOf(2*istorage.getValue()));
        }
        else
            istorage.removeObserver(this);
    }
}
