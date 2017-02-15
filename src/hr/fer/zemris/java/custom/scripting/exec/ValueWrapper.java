package hr.fer.zemris.java.custom.scripting.exec;

import hr.fer.zemris.java.tecaj.hw3.prob1.NumberSubLexer;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Created by akarlovic on 13.2.2017..
 */
public class ValueWrapper<E> {
    private static List<Class> allowedTypes = new ArrayList<Class>(){{
        add(null);
        add(String.class);
        add(Integer.class);
        add(Double.class);
    }};
    private Object value;
    private String strValue;
    private static Double dobValue;
    private static Integer intValue;

    private void checkType(Object toCheck){
        if (!allowedTypes.contains(toCheck.getClass()))
            throw new RuntimeException("Unallowed types!");
    }

    public ValueWrapper(Object initialValue){
        checkType(initialValue);
        value = initialValue;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        checkType(value);
        this.value = value;
    }

    private void tryParse(){
        try {
            intValue = Integer.parseInt(strValue);
            return;
        }catch (NumberFormatException e){
            System.out.println("Not integers");
        }
        try {
            dobValue = Double.parseDouble(strValue);
            return;
        }catch (NumberFormatException e){
            System.out.println("Not even doubles, smth is wrong.");
            throw new RuntimeException("Couldn't parse objects.");
        }
    }


    public void increment(Object incValue){
        checkType(incValue);
        strValue = String.valueOf(incValue);
        dobValue = null;
        intValue = null;

        tryParse();

        if(this.value == null){
            this.value = (Object)intValue;
            return;
        }

        if (dobValue != null){
            double stored = Double.parseDouble(String.valueOf(this.value));
            stored += dobValue;
            this.value = (Object)stored;
        }
        else {
            int stored = Integer.parseInt(String.valueOf(this.value));
            stored += intValue;
            this.value = (Object)stored;
        }
    }
    public void decrement(Object decValue){
        checkType(decValue);
        strValue = String.valueOf(decValue);
        dobValue = null;
        intValue = null;

        tryParse();

        if(this.value == null){
            this.value = (Object)(-intValue);
            return;
        }

        if (dobValue != null){
            double stored = Double.parseDouble(String.valueOf(this.value));
            stored -= dobValue;
            this.value = (Object)stored;
        }
        else {
            int stored = Integer.parseInt(String.valueOf(this.value));
            stored -= intValue;
            this.value = (Object)stored;
        }
    }
    public void multiply(Object mulValue){
        checkType(mulValue);
        strValue = String.valueOf(mulValue);
        dobValue = null;
        intValue = null;

        tryParse();

        if(this.value == null){
            this.value = (Object)(intValue);
            return;
        }

        if (dobValue != null){
            double stored = Double.parseDouble(String.valueOf(this.value));
            stored *= dobValue;
            this.value = (Object)stored;
        }
        else {
            int stored = Integer.parseInt(String.valueOf(this.value));
            stored *= intValue;
            this.value = (Object)stored;
        }
    }
    public void divide(Object divValue){
        checkType(divValue);
        strValue = String.valueOf(divValue);
        dobValue = null;
        intValue = null;

        tryParse();

        if(this.value == null){
            return;
        }

        if (dobValue != null){
            double stored = Double.parseDouble(String.valueOf(this.value));
            if (dobValue == 0)
                throw new RuntimeException("Division by zero");
            stored /= dobValue;
            this.value = (Object)stored;
        }
        else {
            int stored = Integer.parseInt(String.valueOf(this.value));
            if (intValue == 0)
                throw new RuntimeException("Division by zero");
            stored /= intValue;
            this.value = (Object)stored;
        }
    }
    public int numCompare(Object withValue){
        if (this.value == null && withValue == null)
            return 0;

        strValue = String.valueOf(withValue);
        dobValue = null;
        intValue = null;

        tryParse();

        if (this.value == null){
            return (0 - Integer.parseInt(strValue));
        }

        if (dobValue != null){
            double value = Double.parseDouble(String.valueOf(this.value));
            if ( value - dobValue < 0)
                return -1;
            if (value -dobValue > 0)
                return 1;
            return 0;
        }

        return (Integer.parseInt((String)this.value) - intValue);
    }

}
