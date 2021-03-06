package hr.fer.zemris.java.tecaj.hw5.db.lexer;

/**
 * Created by akarlovic on 10.2.2017..
 */
public class AndSubLexer extends AbstractSubLexer {
    @Override
    protected TokenValidResult tokenValid(char[] data, int currentIndex) {
        return new TokenValidResult(true, 1, String.valueOf(data[currentIndex]));
    }

    @Override
    protected TokenType getTokenType() {
        return TokenType.AND;
    }

    @Override
    protected Object getTokenValue() {
        return tokenValue;
    }
}
