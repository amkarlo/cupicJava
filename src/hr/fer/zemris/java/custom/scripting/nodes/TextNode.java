package hr.fer.zemris.java.custom.scripting.nodes;

/**
 * Created by akarlovic on 19.1.2017..
 */
public class TextNode extends Node {
    private String text;

    public TextNode(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
