package hr.fer.zemris.java.custom.scripting.exec;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akarlovic on 13.2.2017..
 */
public class ObjectMultistack {
    Map<String, MultistackEntry> objectMap;

    public ObjectMultistack(){
        objectMap = new HashMap<String, MultistackEntry>();
    }

    private class MultistackEntry {
        public ValueWrapper value;
        public MultistackEntry next;

        public MultistackEntry(ValueWrapper value){
            this.value = value;
            this.next = null;
        }
    }

    private MultistackEntry iterateToLast(String name){
        MultistackEntry node = objectMap.get(name);
        while(node.next != null && node.next.next != null)
            node = node.next;
        return node;
    }

    public void push(String name, ValueWrapper valueWrapper) {
        if (objectMap.containsKey(name)){
            MultistackEntry first = objectMap.get(name);
            while(first.next != null)
                first = first.next;
            first.next = new MultistackEntry(valueWrapper);
        }
        else {
            objectMap.put(name, new MultistackEntry(valueWrapper));
        }
    }

    public ValueWrapper pop(String name) {
        if (objectMap.get(name) == null)
            throw new IllegalArgumentException();

        MultistackEntry node = iterateToLast(name);

        ValueWrapper value;
        if (node.next != null) {
            value = node.next.value;
            node.next = null;
        }
        else
            value = node.value;
        return value;
    }

    public ValueWrapper peek(String name) {
        if (objectMap.get(name) == null)
            throw new IllegalArgumentException();

        MultistackEntry node = iterateToLast(name);

        if (node.next != null)
            return node.next.value;
        return node.value;
    }

    public boolean isEmpty(String name) {
        if (objectMap.size() == 0)
            return true;
        return false;
    }

}
