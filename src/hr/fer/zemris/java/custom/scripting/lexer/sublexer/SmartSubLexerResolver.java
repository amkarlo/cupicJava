package hr.fer.zemris.java.custom.scripting.lexer.sublexer;

import hr.fer.zemris.java.custom.scripting.lexer.SmartLexerState;
import hr.fer.zemris.java.custom.scripting.lexer.SmartTokenType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akarlovic on 24.1.2017..
 */
public class SmartSubLexerResolver {
    private static Map<SmartLexerState, Map<SmartTokenType, ISmartSubLexer>> subLexers = new HashMap<SmartLexerState, Map<SmartTokenType, ISmartSubLexer>>() {
        {
            put(SmartLexerState.TAG, new HashMap<SmartTokenType, ISmartSubLexer>() {{
                put(SmartTokenType.FOR, null);
                put(SmartTokenType.EQUALS, null);
                put(SmartTokenType.VARIABLE, null);
                put(SmartTokenType.NUMBER, null);
                put(SmartTokenType.STRING, null);

            }});
            put(SmartLexerState.TEXT, new HashMap<SmartTokenType, ISmartSubLexer>() {{
                put(SmartTokenType.TEXT, null);
            }});
        }
    };

    public static ISmartSubLexer getSubLexer(SmartLexerState state, SmartTokenType tokenType) {
        return subLexers.get(state).get(tokenType);
    }
}
