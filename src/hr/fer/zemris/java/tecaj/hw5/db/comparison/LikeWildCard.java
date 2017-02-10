package hr.fer.zemris.java.tecaj.hw5.db.comparison;

/**
 * Created by akarlovic on 10.2.2017..
 */
public class LikeWildCard implements IComparisonOperator {
    @Override
    public boolean satisfied(String value1, String value2) {
        value2 = value2.replace('*', '.');
        return value1.matches(value2);
    }
}
