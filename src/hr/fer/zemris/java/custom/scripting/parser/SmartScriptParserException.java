package hr.fer.zemris.java.custom.scripting.parser;

/**
 * Created by akarlovic on 20.1.2017..
 */
public class SmartScriptParserException extends RuntimeException {
    SmartScriptParserException(){
        super();
    }
    SmartScriptParserException(String message){
        super(message);
    }
    SmartScriptParserException(String message, Throwable cause){
        super(message, cause);
    }
}
