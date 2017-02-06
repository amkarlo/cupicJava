package hr.fer.zemris.java.custom.scripting.nodes;

import hr.fer.zemris.java.custom.scripting.elems.Element;

/**
 * Created by akarlovic on 19.1.2017..
 */
public class EchoNode extends Node {
    Element[] elements;

    public EchoNode(){ }

    public Element getElement(int i) {
        return elements[i];
    }
}
