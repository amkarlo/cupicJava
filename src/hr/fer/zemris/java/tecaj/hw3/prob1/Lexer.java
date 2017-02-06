package hr.fer.zemris.java.tecaj.hw3.prob1;

/**
 * Created by akarlovic on 19.1.2017..
 */
public class Lexer {
    private char[] data;
    private Token token;
    private int currentIndex;
    private LexerState state;

    public Lexer(String text) {
        if (null == text)
            throw new IllegalArgumentException("Cannot parse null");
        this.data = text.toCharArray();
        this.currentIndex = 0;
        state = LexerState.BASIC;
    }

    boolean isItLetter(char c){
        if (Character.isLetter(c))
            return true;
        if ('\\' == data[currentIndex] && (currentIndex+1) < data.length)
            if (Character.isDigit(data[currentIndex+1]) || data[currentIndex+1] == '\\')
                return true;
        return false;
    }

    TokenType define(char c){
        if (isItLetter(c))
            return TokenType.WORD;
        if (Character.isDigit(c))
            return TokenType.NUMBER;
        if ('\\' == c){
            if ((this.data.length-1) == this.currentIndex)
                throw new LexerException("Cannot parse: invalid use of character \\");
            if (Character.isDigit(this.data[this.currentIndex]) || '\\' == this.data[this.currentIndex])
                return TokenType.WORD;
            else
                throw new LexerException("Cannot parse: invalid use of character \\");
        }
        return TokenType.SYMBOL;
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
        SubLexerToken expandedToken = SubLexerResolver.getSubLexer(state, define(data[currentIndex])).getToken(data, currentIndex);
        token = (Token) expandedToken;
        currentIndex = expandedToken.getContinueFromIdx();
        state = expandedToken.getContinueWithState();
        return token;
    }

    public Token getToken(){
        return  this.token;
    }

    public void setState(LexerState state) {
        if (state == null)
            throw new IllegalArgumentException("State cannot be null");
        this.state = state;
    }
}
