package hr.fer.zemris.java.tecaj.hw5.db.conditional;

import hr.fer.zemris.java.tecaj.hw5.db.StudentRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akarlovic on 10.2.2017..
 */
public class CompositeConditional implements IConditional {
    List<IConditional> conditions = new ArrayList<IConditional>();

    public void add(IConditional condition){
        conditions.add(condition);
    }

    public void removeAll(){
        conditions.clear();
    }

    @Override
    public boolean examine(StudentRecord record) {
        for (IConditional condition : conditions) {
            if (!condition.examine(record))
                return false;
        }
        return true;
    }
}
