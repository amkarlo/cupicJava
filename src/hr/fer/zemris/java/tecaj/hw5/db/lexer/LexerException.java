package hr.fer.zemris.java.tecaj.hw5.db.lexer;

/**
 * Created by akarlovic on 19.1.2017..
 */
public class LexerException extends RuntimeException {

    public LexerException(){
            super();
        }
    public LexerException(String message){
            super(message);
        }
    LexerException(String message, Throwable cause){
        super(message, cause);
    }
}
