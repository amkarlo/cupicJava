package hr.fer.zemris.java.tecaj.hw5.db.conditional;

import hr.fer.zemris.java.tecaj.hw5.db.fieldValueGetters.IFieldValueGetter;
import hr.fer.zemris.java.tecaj.hw5.db.StudentRecord;
import hr.fer.zemris.java.tecaj.hw5.db.comparison.IComparisonOperator;

/**
 * Created by akarlovic on 10.2.2017..
 */
public class ConditionalExpression implements IConditional {
    private IFieldValueGetter fieldValueGetter;
    private String value;
    private IComparisonOperator comparisonOperator;

    public ConditionalExpression(IFieldValueGetter fieldValueGetter, String value, IComparisonOperator comparisonOperator) {
        this.fieldValueGetter = fieldValueGetter;
        this.value = value;
        this.comparisonOperator = comparisonOperator;
    }


    @Override
    public boolean examine(StudentRecord record) {
        boolean recordSatisfies = comparisonOperator.satisfied(fieldValueGetter.get(record), value);
        return recordSatisfies;
    }
}
