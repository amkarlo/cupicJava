package hr.fer.zemris.java.custom.scripting.lexer.sublexer;

import hr.fer.zemris.java.custom.scripting.lexer.SmartLexerState;
import hr.fer.zemris.java.custom.scripting.lexer.SmartTokenType;
import hr.fer.zemris.java.custom.scripting.lexer.SmartTokenValidResult;

/**
 * Created by akarlovic on 1.2.2017..
 */
public abstract class AbstractSmartSubLexer implements ISmartSubLexer {
    SmartLexerState state;
    String tokenValue;

    @Override
    public SubLexerSmartToken getToken(char[] data, int startingIndex) {
        tokenValue = "";
        int currentIndex = startingIndex;
        while (currentIndex < data.length && !Character.isWhitespace(data[currentIndex])) {
            SmartTokenValidResult result = tokenValid(data, currentIndex);
            tokenValue += result.getSymbol();
            currentIndex += result.getMove();
            if (!result.isValid())
                break;
        }
        return new SubLexerSmartToken(getTokenType(), getTokenValue(), currentIndex, state);
    }

    protected abstract SmartTokenValidResult tokenValid(char[] data, int currentIndex);

    protected abstract SmartTokenType getTokenType();

    protected abstract Object getTokenValue();
}
