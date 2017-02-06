package hr.fer.zemris.java.tecaj.hw3.prob1;

/**
 * Created by akarlovic on 20.1.2017..
 */
public class WordExtendedSubLexer extends AbstractSubLexer {

    WordExtendedSubLexer(){
        state = LexerState.EXTENDED;
    }

    @Override
    protected TokenValidResult tokenValid(char[] data, int currentIndex) {
        if (data[currentIndex] == '#') {
            if (tokenValue.equals("")) {
                state = LexerState.BASIC;
                return new TokenValidResult(false, 1, "#");
            }
            else
                return new TokenValidResult(false, 0, "");
        }
        return new TokenValidResult(true, 1, String.valueOf(data[currentIndex]));
    }

    @Override
    protected TokenType getTokenType() {
        if (state == LexerState.BASIC)
            return TokenType.SYMBOL;
        else
            return TokenType.WORD;
    }

    @Override
    protected Object getTokenValue() {
        if (state == LexerState.BASIC)
            return tokenValue.charAt(0);
        else
            return tokenValue;
    }
}
