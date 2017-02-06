package hr.fer.zemris.java.tecaj.hw3.prob1;

import hr.fer.zemris.java.custom.scripting.lexer.SmartTokenType;

/**
 * Created by akarlovic on 20.1.2017..
 */
public interface ISubLexer {

    public SubLexerToken getToken(char[] data, int currentIndex);
}
