package hr.fer.zemris.java.custom.scripting.exec;

import java.util.ArrayList;
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


    public void increment(Object incValue){
        checkType(incValue);
        if (incValue.getClass().equals(String.class)){
            String strValue = (String)incValue;
            if (strValue.contains(".") || strValue.contains("E")){
                Double dobValue = (Double) incValue;
            }
        }

    }
    public void decrement(Object decValue){}
    public void multiply(Object mulValue){}
    public void divide(Object divValue){}
    public int numCompare(Object withValue){ return 0;}

}
