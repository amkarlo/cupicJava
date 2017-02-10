package hr.fer.zemris.java.tecaj.hw5.db.fieldValueGetters;

import hr.fer.zemris.java.tecaj.hw5.db.StudentRecord;

/**
 * Created by akarlovic on 9.2.2017..
 */
public class LastNameFieldGetter implements IFieldValueGetter {
    @Override
    public String get(StudentRecord record) {
        return record.getLastName();
    }
}
