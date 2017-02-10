package hr.fer.zemris.java.tecaj.hw5.db.lexer;

/**
 * Created by akarlovic on 9.2.2017..
 */
public class ValueSubLexer extends AbstractSubLexer {
    @Override
    protected TokenValidResult tokenValid(char[] data, int currentIndex) {
        if (data[currentIndex] != '"')
            return new TokenValidResult(true, 1, String.valueOf(data[currentIndex]));

        return new TokenValidResult(false, 1, "");
    }

    @Override
    protected TokenType getTokenType() {
        return TokenType.VALUE;
    }

    @Override
    protected Object getTokenValue() {
        return tokenValue;
    }
}
