package hr.fer.zemris.java.custom.scripting.lexer.sublexer;

import hr.fer.zemris.java.custom.scripting.lexer.SmartTokenType;
import hr.fer.zemris.java.custom.scripting.lexer.SmartTokenValidResult;

/**
 * Created by akarlovic on 1.2.2017..
 */
public class TextSmartSubLexer extends AbstractSmartSubLexer{
    @Override
    protected SmartTokenValidResult tokenValid(char[] data, int currentIndex) {
        if (data[currentIndex] == '{') {
            return new SmartTokenValidResult(false, 0, "");
        }
        return new SmartTokenValidResult(true, 1, String.valueOf(data[currentIndex]));
    }

    @Override
    protected SmartTokenType getTokenType() {
        return SmartTokenType.TEXT;
    }

    @Override
    protected Object getTokenValue() {
        return tokenValue;
    }

}
