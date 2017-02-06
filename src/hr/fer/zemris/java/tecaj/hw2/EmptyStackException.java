package hr.fer.zemris.java.tecaj.hw2;

/**
 * Created by akarlovic on 18.1.2017..
 */
public class EmptyStackException extends RuntimeException{
    EmptyStackException(){
        super();
    }
    EmptyStackException(String message){
        super(message);
    }
    EmptyStackException(String message, Throwable cause){
        super(message, cause);
    }

}
