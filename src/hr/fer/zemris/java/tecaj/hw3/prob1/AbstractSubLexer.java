package hr.fer.zemris.java.tecaj.hw3.prob1;

import java.util.Arrays;

/**
 * Created by akarlovic on 20.1.2017..
 */
public abstract class AbstractSubLexer implements ISubLexer {
    LexerState state;
    String tokenValue;

    @Override
    public SubLexerToken getToken(char[] data, int startingIndex) {
        tokenValue = "";
        int currentIndex = startingIndex;
        while (currentIndex < data.length && !Character.isWhitespace(data[currentIndex])) {
            TokenValidResult result = tokenValid(data, currentIndex);
            tokenValue += result.getSymbol();
            currentIndex += result.getMove();
            if (!result.isValid())
                break;
        }
        return new SubLexerToken(getTokenType(), getTokenValue(), currentIndex, state);
    }

    protected abstract TokenValidResult tokenValid(char[] data, int currentIndex);

    protected abstract TokenType getTokenType();

    protected abstract Object getTokenValue();
}
