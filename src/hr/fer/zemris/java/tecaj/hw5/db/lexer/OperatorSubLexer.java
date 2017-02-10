package hr.fer.zemris.java.tecaj.hw5.db.lexer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akarlovic on 9.2.2017..
 */
public class OperatorSubLexer extends AbstractSubLexer {
    private static List<Character> operators = new ArrayList<Character>(){{
        add('<');
        add('>');
        add('=');
        add('!');
    }};

    @Override
    protected TokenValidResult tokenValid(char[] data, int currentIndex) {
        if (operators.contains(data[currentIndex]))
            return new TokenValidResult(true, 1, String.valueOf(data[currentIndex]));
        return new TokenValidResult(false, 0, "");
    }

    @Override
    protected TokenType getTokenType() {
        return TokenType.OPERATOR;
    }

    @Override
    protected Object getTokenValue() {
        return tokenValue;
    }
}
