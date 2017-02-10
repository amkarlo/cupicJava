package hr.fer.zemris.java.tecaj.hw5.db.lexer;

/**
 * Created by akarlovic on 20.1.2017..
 */
public interface ISubLexer {

    public SubLexerToken getToken(char[] data, int currentIndex);
}
