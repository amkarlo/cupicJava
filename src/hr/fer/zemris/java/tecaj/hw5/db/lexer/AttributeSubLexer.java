package hr.fer.zemris.java.tecaj.hw5.db.lexer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akarlovic on 9.2.2017..
 */
public class AttributeSubLexer extends AbstractSubLexer {
    @Override
    protected TokenValidResult tokenValid(char[] data, int currentIndex) {
        if ( Character.isLetter(data[currentIndex]))
            return new TokenValidResult(true, 1, String.valueOf(data[currentIndex]));

        return new TokenValidResult(false, 0, "");
    }

    @Override
    protected TokenType getTokenType() {
        return TokenType.ATTRIBUTE;
    }

    @Override
    protected Object getTokenValue() {
        return tokenValue;
    }
}
