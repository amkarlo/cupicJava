package hr.fer.zemris.java.custom.scripting.nodes;

import hr.fer.zemris.java.tecaj.hw2.ArrayIndexedCollection;

/**
 * Created by akarlovic on 19.1.2017..
 */
public class Node {
    ArrayIndexedCollection children;

    public void addChildNode(Node child){
        this.children.add(child);
    }

    public int numberOfChildren() {
        return this.children.size();
    }

    public Node getChild(int index){
        return (Node)this.children.get(index);
    }
}
