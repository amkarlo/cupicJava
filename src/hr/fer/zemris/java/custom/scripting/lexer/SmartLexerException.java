package hr.fer.zemris.java.custom.scripting.lexer;

/**
 * Created by akarlovic on 20.1.2017..
 */
public class SmartLexerException extends RuntimeException {
    SmartLexerException(){
        super();
    }
    public SmartLexerException(String message){
        super(message);
    }
    SmartLexerException(String message, Throwable cause){
        super(message, cause);
    }
}
