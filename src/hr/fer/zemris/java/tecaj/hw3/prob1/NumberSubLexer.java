package hr.fer.zemris.java.tecaj.hw3.prob1;

import java.util.Arrays;

/**
 * Created by akarlovic on 20.1.2017..
 */
public class NumberSubLexer extends AbstractSubLexer {

    NumberSubLexer(){
        state = LexerState.BASIC;
    }

    @Override
    protected TokenValidResult tokenValid(char[] data, int currentIndex) {
        if(Character.isDigit(data[currentIndex]))
            return new TokenValidResult(true, 1, String.valueOf(data[currentIndex]));
        else
            return new TokenValidResult(false, 0, "");
    }

    @Override
    protected TokenType getTokenType() {
        return TokenType.NUMBER;
    }

    @Override
    protected Object getTokenValue() {
        try {
            Long number = Long.parseLong(tokenValue);
            return number;
        }
        catch (NumberFormatException e){
            throw new LexerException("Unable to parse - number too long");
        }
    }
}
