package hr.fer.zemris.java.custom.scripting.lexer.sublexer;

import hr.fer.zemris.java.custom.scripting.lexer.SmartTokenType;
import hr.fer.zemris.java.custom.scripting.lexer.SmartTokenValidResult;

/**
 * Created by akarlovic on 1.2.2017..
 */
public class NumberSmartSubLexer extends AbstractSmartSubLexer {
    boolean isDouble = false;
    @Override
    protected SmartTokenValidResult tokenValid(char[] data, int currentIndex) {
        if (data[currentIndex] == '.') {
            isDouble = true;
        }
        return new SmartTokenValidResult(true, 1, String.valueOf(data[currentIndex]));
    }

    @Override
    protected SmartTokenType getTokenType() {
        return SmartTokenType.NUMBER;
    }

    @Override
    protected Object getTokenValue() {
        if (isDouble)
            return Double.parseDouble(tokenValue);
        else
            return Integer.parseInt(tokenValue);
    }
}
