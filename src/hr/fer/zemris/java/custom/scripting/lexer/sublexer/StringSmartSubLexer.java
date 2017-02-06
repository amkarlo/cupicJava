package hr.fer.zemris.java.custom.scripting.lexer.sublexer;

import hr.fer.zemris.java.custom.scripting.lexer.SmartTokenType;
import hr.fer.zemris.java.custom.scripting.lexer.SmartTokenValidResult;

/**
 * Created by akarlovic on 1.2.2017..
 */
public class StringSmartSubLexer extends AbstractSmartSubLexer {
    @Override
    protected SmartTokenValidResult tokenValid(char[] data, int currentIndex) {
        if (data[currentIndex] == '"' && !tokenValue.equals("")) {
            return new SmartTokenValidResult(false, 1, String.valueOf(data[currentIndex]));
        }
        return new SmartTokenValidResult(true, 1, String.valueOf(data[currentIndex]));
    }

    @Override
    protected SmartTokenType getTokenType() {
        return SmartTokenType.STRING;
    }

    @Override
    protected Object getTokenValue() {
        return tokenValue;
    }
}
