package hr.fer.zemris.java.custom.scripting.nodes;

import hr.fer.zemris.java.tecaj.hw2.ArrayIndexedCollection;


/**
 * Created by akarlovic on 19.1.2017..
 */
public class DocumentNode extends Node {
    ArrayIndexedCollection collection;

    public DocumentNode(){
        this.collection = new ArrayIndexedCollection();
    }
}
