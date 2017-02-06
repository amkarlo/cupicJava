package hr.fer.zemris.java.tecaj.hw3.prob1;

import java.util.Arrays;

/**
 * Created by akarlovic on 20.1.2017..
 */
public class WordSubLexer extends AbstractSubLexer {

    WordSubLexer(){
        this.state = LexerState.BASIC;
    }

    @Override
    protected TokenValidResult tokenValid(char[] data, int currentIndex) {
        if(Character.isLetter(data[currentIndex])) {
            return new TokenValidResult(true, 1, String.valueOf(data[currentIndex]));
        } else {
            if ('\\' == data[currentIndex]) {
                if ((currentIndex+1) < data.length && ('\\' == data[currentIndex+1] || Character.isDigit(data[currentIndex+1])))
                    return new TokenValidResult(true, 2, String.valueOf(data[currentIndex+1]));
                else
                    throw new LexerException("Unallowed use of character \\");
            } else
                return new TokenValidResult(false, 0, "");
        }
    }

    @Override
    protected TokenType getTokenType() {
        return TokenType.WORD;
    }

    @Override
    protected Object getTokenValue() {
        return tokenValue;
    }
}
