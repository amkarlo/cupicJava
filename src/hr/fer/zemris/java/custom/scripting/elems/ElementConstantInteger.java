package hr.fer.zemris.java.custom.scripting.elems;

/**
 * Created by akarlovic on 19.1.2017..
 */
public class ElementConstantInteger extends Element {
    private int value;

    @Override
    public String asText(){
        return String.valueOf(value);
    }
}
