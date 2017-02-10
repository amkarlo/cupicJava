package hr.fer.zemris.java.tecaj.hw5.db.comparison;

/**
 * Created by akarlovic on 10.2.2017..
 */
public class Differs implements IComparisonOperator {
    @Override
    public boolean satisfied(String value1, String value2) {
        if (value1.compareToIgnoreCase(value2) == 0)
            return false;
        return true;
    }
}
