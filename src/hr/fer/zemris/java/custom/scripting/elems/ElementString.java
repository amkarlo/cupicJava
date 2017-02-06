package hr.fer.zemris.java.custom.scripting.elems;

/**
 * Created by akarlovic on 19.1.2017..
 */
public class ElementString extends Element {
    private String value;

    @Override
    public String asText(){
        return this.value;
    }
}
