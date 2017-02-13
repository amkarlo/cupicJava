package hr.fer.zemris.java.tecaj.hw6.observer2;

import hr.fer.zemris.java.tecaj.hw6.observer2.ChangeCounter;
import hr.fer.zemris.java.tecaj.hw6.observer2.DoubleValue;
import hr.fer.zemris.java.tecaj.hw6.observer2.IntegerStorage;
import hr.fer.zemris.java.tecaj.hw6.observer2.IntegerStorageObserver;
import hr.fer.zemris.java.tecaj.hw6.observer2.SquareValue;

/**
 * Created by akarlovic on 13.2.2017..
 */
public class ObserverExample {
    public static void main(String[] args) {
       IntegerStorage istorage = new IntegerStorage(20);

        IntegerStorageObserver observer = new SquareValue();

        istorage.addObserver(observer);
        istorage.addObserver(new ChangeCounter());
        istorage.addObserver(new DoubleValue(2));
        istorage.addObserver(new DoubleValue(1));
        istorage.addObserver(new DoubleValue(2));

        istorage.setValue(5);
        istorage.setValue(2);
        istorage.setValue(25);
        istorage.removeObserver(observer);

        istorage.setValue(13);
        istorage.setValue(22);
        istorage.setValue(15);
    }

}
