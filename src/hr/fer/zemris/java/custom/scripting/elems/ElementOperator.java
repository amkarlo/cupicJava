package hr.fer.zemris.java.custom.scripting.elems;

/**
 * Created by akarlovic on 19.1.2017..
 */
public class ElementOperator extends Element {
    private String symbol;

    @Override
    public String asText() {
        return this.symbol;
    }
}
