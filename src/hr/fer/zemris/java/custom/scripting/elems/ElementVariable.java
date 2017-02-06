package hr.fer.zemris.java.custom.scripting.elems;

/**
 * Created by akarlovic on 19.1.2017..
 */
public class ElementVariable extends Element {
    private String name;

    @Override
    public String asText(){
        return this.name;
    }
}
