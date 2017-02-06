package hr.fer.zemris.java.custom.scripting.lexer.sublexer;

import hr.fer.zemris.java.custom.scripting.lexer.SmartTokenType;
import hr.fer.zemris.java.custom.scripting.lexer.SmartTokenValidResult;

/**
 * Created by akarlovic on 1.2.2017..
 */
public class FunctionSmartSubLexer extends AbstractSmartSubLexer {

    @Override
    protected SmartTokenValidResult tokenValid(char[] data, int currentIndex) {
        if (data[currentIndex] == '@') {
            return new SmartTokenValidResult(true, 1, "");
        }
        return new SmartTokenValidResult(true, 1, String.valueOf(data[currentIndex]));
    }

    @Override
    protected SmartTokenType getTokenType() {
        return SmartTokenType.FUNCTION;
    }

    @Override
    protected Object getTokenValue() {
        return tokenValue;
    }
}
