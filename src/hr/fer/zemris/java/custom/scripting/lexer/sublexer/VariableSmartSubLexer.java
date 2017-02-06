package hr.fer.zemris.java.custom.scripting.lexer.sublexer;

import hr.fer.zemris.java.custom.scripting.lexer.SmartLexerException;
import hr.fer.zemris.java.custom.scripting.lexer.SmartTokenType;
import hr.fer.zemris.java.custom.scripting.lexer.SmartTokenValidResult;

/**
 * Created by akarlovic on 1.2.2017..
 */
public class VariableSmartSubLexer extends AbstractSmartSubLexer {
    @Override
    protected SmartTokenValidResult tokenValid(char[] data, int currentIndex) {
        if (tokenValue.equals("") && !Character.isLetter(data[currentIndex])) {
            throw new SmartLexerException("Name of a variable can't start with a " + data[currentIndex]);
        }
        return new SmartTokenValidResult(true, 1, String.valueOf(data[currentIndex]));
    }

    @Override
    protected SmartTokenType getTokenType() {
        return SmartTokenType.VARIABLE;
    }

    @Override
    protected Object getTokenValue() {
        return tokenValue;
    }
}
