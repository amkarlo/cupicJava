package hr.fer.zemris.java.tecaj.hw5.db.lexer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akarlovic on 20.1.2017..
 */
public class SubLexerResolver {

    private static Map<TokenType, ISubLexer> subLexers = new HashMap<TokenType, ISubLexer>() {
        {
            put(TokenType.QUERY, new QuerySubLexer());
            put(TokenType.ATTRIBUTE, new AttributeSubLexer());
            put(TokenType.OPERATOR, new OperatorSubLexer());
            put(TokenType.VALUE, new ValueSubLexer());
            put(TokenType.AND, new AndSubLexer());
            put(TokenType.LIKE, new LikeSubLexer());
        }
    };

    public static ISubLexer getSubLexer(TokenType tokenType) {
        return subLexers.get(tokenType);
    }
}
