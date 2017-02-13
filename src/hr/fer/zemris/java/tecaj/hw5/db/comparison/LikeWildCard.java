package hr.fer.zemris.java.tecaj.hw5.db.comparison;

/**
 * Created by akarlovic on 10.2.2017..
 */
public class LikeWildCard implements IComparisonOperator {
    @Override
    public boolean satisfied(String value1, String value2) {
        String toMatch = "";
        for (int i=0; i < value2.length(); ++i){
            if (value2.charAt(i) == '*'){
                toMatch += "(.*)";
            }
            else
                toMatch += value2.charAt(i);
        }
        return value1.matches(toMatch);
    }
}
