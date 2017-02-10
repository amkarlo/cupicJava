package hr.fer.zemris.java.tecaj.hw5.db.lexer;

import hr.fer.zemris.java.tecaj.hw3.prob1.LexerState;

/**
 * Created by akarlovic on 20.1.2017..
 */
public class SubLexerToken extends Token {
    private final int continueFromIdx;

    public SubLexerToken(TokenType type, Object value, int index){
        super(type, value);
        continueFromIdx = index;
    }

    public int getContinueFromIdx() {
        return continueFromIdx;
    }
}
