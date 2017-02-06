package hr.fer.zemris.java.custom.scripting.lexer;

/**
 * Created by akarlovic on 20.1.2017..
 */
public class SmartToken {
    private  Object value;
    private  SmartTokenType type;

    public SmartToken() { }

    public SmartToken(SmartTokenType type, Object value){
        this.type = type;
        this.value = value;
    }

    public Object getValue(){
        return this.value;
    }
    public void setValue(Object value){
        this.value = value;
    }
    public SmartTokenType getType(){
        return this.type;
    }
}
