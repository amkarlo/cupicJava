package hr.fer.zemris.java.tecaj.hw3.prob1;

/**
 * Created by akarlovic on 20.1.2017..
 */
public class SymbolSubLexer extends AbstractSubLexer {

    SymbolSubLexer(){
        state = LexerState.BASIC;
    }

    @Override
    protected TokenValidResult tokenValid(char[] data, int currentIndex) {
        if ('#' == data[currentIndex])
            state = LexerState.EXTENDED;
        if (tokenValue.equals(""))
            return new TokenValidResult(true, 1, String.valueOf(data[currentIndex]));
        else
            return new TokenValidResult(false, 0, "");
    }

    @Override
    protected TokenType getTokenType() {
        return TokenType.SYMBOL;
    }

    @Override
    protected Object getTokenValue() { return tokenValue.charAt(0); }
}
