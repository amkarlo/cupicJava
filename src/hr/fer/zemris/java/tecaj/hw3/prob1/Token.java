package hr.fer.zemris.java.tecaj.hw3.prob1;

/**
 * Created by akarlovic on 19.1.2017..
 */
public class Token {
    private  Object value;
    private  TokenType type;

    public Token(TokenType type, Object value){
        this.type = type;
        this.value = value;
    }
    public Object getValue(){
        return this.value;
    }
    public TokenType getType(){
        return this.type;
    }
}
