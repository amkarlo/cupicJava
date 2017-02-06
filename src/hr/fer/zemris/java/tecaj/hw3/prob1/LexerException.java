package hr.fer.zemris.java.tecaj.hw3.prob1;

/**
 * Created by akarlovic on 19.1.2017..
 */
public class LexerException extends RuntimeException {

    LexerException(){
            super();
        }
    LexerException(String message){
            super(message);
        }
    LexerException(String message, Throwable cause){
        super(message, cause);
    }
}
