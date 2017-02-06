package hr.fer.zemris.java.custom.scripting.elems;

/**
 * Created by akarlovic on 19.1.2017..
 */
public class ElementConstantDouble extends Element {
    private double value;

    @Override
    public String asText(){
        return String.valueOf(this.value);
    }
}
