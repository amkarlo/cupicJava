package hr.fer.zemris.java.tecaj.hw5.db.lexer;

import hr.fer.zemris.java.tecaj.hw3.prob1.*;

import java.util.Arrays;

/**
 * Created by akarlovic on 19.1.2017..
 */
public class Lexer {
    private char[] data;
    private Token token;
    private int currentIndex;

    public Lexer(String text) {
        if (null == text)
            throw new IllegalArgumentException("Cannot parse null");
        this.data = text.toCharArray();
        this.currentIndex = 0;
    }

    private TokenType define(){
        char c = data[currentIndex];

        if (c == '"') {
            ++currentIndex;
            return TokenType.VALUE;
        }
        if (c == '=' || c =='<' || c =='>' || c =='!')
            return TokenType.OPERATOR;

        if (Character.toUpperCase(data[currentIndex]) == 'L'){
            if ((String.valueOf(Arrays.copyOfRange(data, currentIndex, currentIndex + 5))).equalsIgnoreCase("LIKE ")) {
                return TokenType.LIKE;
            }
        }

        if (Character.toUpperCase(data[currentIndex]) == 'A'){
            if ((String.valueOf(Arrays.copyOfRange(data, currentIndex, currentIndex + 4))).equalsIgnoreCase("AND ")) {
                return TokenType.AND;
                }
            }
        String word = String.valueOf(Arrays.copyOfRange(data, currentIndex, currentIndex + 5));
        if (word.equals("query") || word.equals("index"))
            return TokenType.QUERY;

        return TokenType.ATTRIBUTE;
    }

    public Token nextToken(){
        if (null != token && TokenType.EOF == token.getType())
            throw new LexerException("Cannot parse, reached end of file.");

        while((data.length > currentIndex) && Character.isWhitespace(data[currentIndex]))
            ++currentIndex;

        if (data.length == currentIndex) {
            token = new Token(TokenType.EOF, null);
            return token;
        }

        SubLexerToken expandedToken = SubLexerResolver.getSubLexer(define()).getToken(data, currentIndex);
        token = expandedToken;
        currentIndex = expandedToken.getContinueFromIdx();
        return token;
    }

    public Token getToken(){
        return  this.token;
    }

}
