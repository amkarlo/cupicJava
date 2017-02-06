package hr.fer.zemris.java.custom.scripting.lexer.sublexer;

/**
 * Created by akarlovic on 24.1.2017..
 */
public interface ISmartSubLexer {
    public SubLexerSmartToken getToken(char[] data, int currentIndex);
}
