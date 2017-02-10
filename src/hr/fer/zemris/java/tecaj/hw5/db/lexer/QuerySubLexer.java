package hr.fer.zemris.java.tecaj.hw5.db.lexer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akarlovic on 9.2.2017..
 */
public class QuerySubLexer extends AbstractSubLexer {
    private static Map<String, TokenType> queries = new HashMap<String, TokenType>() {
        {
            put("query", TokenType.QUERY);
            put("indexquery", TokenType.INDEXQUERY);
        }
    };

    @Override
    protected TokenValidResult tokenValid(char[] data, int currentIndex) {
        if (Character.isLetter((data[currentIndex])))
            return new TokenValidResult(true, 1, String.valueOf(data[currentIndex]));

        return new TokenValidResult(false, 1, "");
    }

    @Override
    protected TokenType getTokenType() {
        return queries.get(tokenValue);
    }

    @Override
    protected Object getTokenValue() {
        return tokenValue;
    }
}
