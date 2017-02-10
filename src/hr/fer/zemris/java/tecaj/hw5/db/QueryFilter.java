package hr.fer.zemris.java.tecaj.hw5.db;

import hr.fer.zemris.java.tecaj.hw5.db.comparison.*;
import hr.fer.zemris.java.tecaj.hw5.db.fieldValueGetters.FirstNameFieldGetter;
import hr.fer.zemris.java.tecaj.hw5.db.fieldValueGetters.IFieldValueGetter;
import hr.fer.zemris.java.tecaj.hw5.db.fieldValueGetters.JmbagFieldGetter;
import hr.fer.zemris.java.tecaj.hw5.db.fieldValueGetters.LastNameFieldGetter;
import hr.fer.zemris.java.tecaj.hw5.db.conditional.CompositeConditional;
import hr.fer.zemris.java.tecaj.hw5.db.conditional.ConditionalExpression;
import hr.fer.zemris.java.tecaj.hw5.db.lexer.LexerException;
import hr.fer.zemris.java.tecaj.hw5.db.lexer.Lexer;
import hr.fer.zemris.java.tecaj.hw5.db.lexer.Token;
import hr.fer.zemris.java.tecaj.hw5.db.lexer.TokenType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akarlovic on 8.2.2017..
 */
public class QueryFilter implements IFilter{
    private CompositeConditional conditions;

    QueryFilter(CompositeConditional conditions){
        this.conditions = conditions;
    }


    @Override
    public boolean accepts(StudentRecord record) {
        return conditions.examine(record);
    }
}
