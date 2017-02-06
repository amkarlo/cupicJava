package hr.fer.zemris.java.custom.scripting.lexer;

import hr.fer.zemris.java.custom.scripting.lexer.sublexer.SmartSubLexerResolver;
import hr.fer.zemris.java.custom.scripting.lexer.sublexer.SubLexerSmartToken;
import hr.fer.zemris.java.tecaj.hw3.prob1.LexerException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by akarlovic on 20.1.2017..
 */
public class SmartScriptLexer {
    private char[] data;
    private SmartToken token;
    private int currentIndex;
    private SmartLexerState state;

    private static List<Character> operators;
    private static List<SmartTokenType> oneChars;

    public SmartScriptLexer(String text){
        if (null == text)
            throw new IllegalArgumentException("Cannot parse null");
        this.data = text.toCharArray();
        this.currentIndex = 0;
        state = SmartLexerState.TEXT;
        Character[] niz = {'+', '-', '*', '/', '^'};
        operators = Arrays.asList(niz);
        SmartTokenType[] nizTokena = { SmartTokenType.OPERATOR, SmartTokenType.ECHO, SmartTokenType.FOR, SmartTokenType.END };
        oneChars = Arrays.asList(nizTokena);
    }

    boolean checkWhitespace(){
        while((data.length > currentIndex) && Character.isWhitespace(data[currentIndex]))
            ++currentIndex;

        if (data.length == currentIndex)
            return false;

        return true;
    }

    SmartToken define(){
        SmartTokenType type;
        String value = "";

        if (!checkWhitespace())
            throw new SmartLexerException("Unclosed tag!");

        if (data[currentIndex] == '=')
            type = SmartTokenType.ECHO;

        if (operators.contains(data[currentIndex])) {
            if (String.valueOf(data[currentIndex+1]) == " ") {
                value = String.valueOf(data[currentIndex]);
                currentIndex += 2;
                type = SmartTokenType.OPERATOR;
            }
            else
                throw new SmartLexerException("Variable name can't start with " + data[--currentIndex]);
        }

        if (data[currentIndex] == '@')
            type = SmartTokenType.FUNCTION;

        if (data[currentIndex] == '"')
            type = SmartTokenType.STRING;

        if (Character.isDigit(data[currentIndex]))
            type = SmartTokenType.NUMBER;

        if (Character.toUpperCase(data[currentIndex]) == 'F'){
            if ((String.valueOf(Arrays.copyOfRange(data, currentIndex, 4))).equalsIgnoreCase("FOR ")){
                currentIndex += 3;
                type = SmartTokenType.FOR;
            }
            else
                type = SmartTokenType.VARIABLE;
        }

        if (Character.toUpperCase(data[currentIndex]) == 'E'){
            if ((String.valueOf(Arrays.copyOfRange(data, currentIndex, 4))).equalsIgnoreCase("END ")){
                currentIndex += 3;
                type = SmartTokenType.END;
            }
            else
                type = SmartTokenType.VARIABLE;
        }

        type = SmartTokenType.VARIABLE;

        return new SmartToken(type, value);
    }

    public SmartToken nextToken(){
        SmartToken tmpToken;

        if (null != token && SmartTokenType.EOF == token.getType())
            throw new SmartLexerException("Cannot parse, reached end of file.");

        if (!checkWhitespace()){
            token = new SmartToken(SmartTokenType.EOF, null);
            return token;
        }

        SubLexerSmartToken expandedToken;

        if (data[currentIndex] == '{') {
            if (data[++currentIndex] == '$')
                ++currentIndex;
            else
                throw new SmartLexerException("Unknown tag!");
            setState(SmartLexerState.TAG);
        }

        if (state.equals(SmartLexerState.TAG)){
            if (data[currentIndex] == '$'){
                currentIndex += 2;
                expandedToken = SmartSubLexerResolver.getSubLexer(state, SmartTokenType.TEXT).getToken(data, currentIndex);
            }
            tmpToken = define();
            if (oneChars.contains(tmpToken.getType())){
                token = tmpToken;
                return token;
            }
            expandedToken = SmartSubLexerResolver.getSubLexer(state, define().getType()).getToken(data, currentIndex);
        }
        else
            expandedToken = SmartSubLexerResolver.getSubLexer(state, SmartTokenType.TEXT).getToken(data, currentIndex);

        token = (SmartToken) expandedToken;
        currentIndex = expandedToken.getContinueFromIdx();
        state = expandedToken.getContinueWithState();
        return token;
    }

    public SmartToken getToken(){
        return  this.token;
    }

    public void setState(SmartLexerState state) {
        if (state == null)
            throw new IllegalArgumentException("State cannot be null");
        this.state = state;
    }

}
