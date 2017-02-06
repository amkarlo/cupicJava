package hr.fer.zemris.java.custom.scripting.lexer.sublexer;

import hr.fer.zemris.java.custom.scripting.lexer.SmartLexerState;
import hr.fer.zemris.java.custom.scripting.lexer.SmartToken;
import hr.fer.zemris.java.custom.scripting.lexer.SmartTokenType;

/**
 * Created by akarlovic on 24.1.2017..
 */
public class SubLexerSmartToken extends SmartToken {
    private final int continueFromIdx;
    private final SmartLexerState continueWithState;

    public SubLexerSmartToken(SmartTokenType type, Object value, int index, SmartLexerState state){
        super(type, value);
        continueFromIdx = index;
        continueWithState = state;
    }

    public int getContinueFromIdx() {
        return continueFromIdx;
    }

    public SmartLexerState getContinueWithState() {
        return continueWithState;
    }
}
