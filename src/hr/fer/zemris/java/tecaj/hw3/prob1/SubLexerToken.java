package hr.fer.zemris.java.tecaj.hw3.prob1;

/**
 * Created by akarlovic on 20.1.2017..
 */
public class SubLexerToken extends Token {
    private final int continueFromIdx;
    private final LexerState continueWithState;

    public SubLexerToken(TokenType type, Object value, int index, LexerState state){
        super(type, value);
        continueFromIdx = index;
        continueWithState = state;
    }

    public int getContinueFromIdx() {
        return continueFromIdx;
    }

    public LexerState getContinueWithState() {
        return continueWithState;
    }
}
