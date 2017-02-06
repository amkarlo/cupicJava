package hr.fer.zemris.java.tecaj.hw3.prob1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akarlovic on 20.1.2017..
 */
public class SubLexerResolver {

    private static Map<LexerState, Map<TokenType, ISubLexer>> subLexers = new HashMap<LexerState, Map<TokenType, ISubLexer>>() {
        {
            put(LexerState.EXTENDED, new HashMap<TokenType, ISubLexer>() {{
                put(TokenType.WORD, new WordExtendedSubLexer());
                put(TokenType.NUMBER, new WordExtendedSubLexer());
                put(TokenType.SYMBOL, new WordExtendedSubLexer());
            }});
            put(LexerState.BASIC, new HashMap<TokenType, ISubLexer>() {{
                put(TokenType.WORD, new WordSubLexer());
                put(TokenType.NUMBER, new NumberSubLexer());
                put(TokenType.SYMBOL, new SymbolSubLexer());
            }});
        }
    };

    public static ISubLexer getSubLexer(LexerState state, TokenType tokenType) {
        return subLexers.get(state).get(tokenType);
    }
}
