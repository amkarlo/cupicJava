package hr.fer.zemris.java.tecaj.hw5.db;

import hr.fer.zemris.java.tecaj.hw5.collections.SimpleHashtable;
import hr.fer.zemris.java.tecaj.hw5.db.comparison.*;
import hr.fer.zemris.java.tecaj.hw5.db.conditional.CompositeConditional;
import hr.fer.zemris.java.tecaj.hw5.db.conditional.ConditionalExpression;
import hr.fer.zemris.java.tecaj.hw5.db.fieldValueGetters.FirstNameFieldGetter;
import hr.fer.zemris.java.tecaj.hw5.db.fieldValueGetters.IFieldValueGetter;
import hr.fer.zemris.java.tecaj.hw5.db.fieldValueGetters.JmbagFieldGetter;
import hr.fer.zemris.java.tecaj.hw5.db.fieldValueGetters.LastNameFieldGetter;
import hr.fer.zemris.java.tecaj.hw5.db.lexer.Lexer;
import hr.fer.zemris.java.tecaj.hw5.db.lexer.LexerException;
import hr.fer.zemris.java.tecaj.hw5.db.lexer.Token;
import hr.fer.zemris.java.tecaj.hw5.db.lexer.TokenType;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by akarlovic on 10.2.2017..
 */
public class QueryReader {
    private static SimpleHashtable<String, IFieldValueGetter> fields = new SimpleHashtable<String, IFieldValueGetter>(){
        {
            put("jmbag", new JmbagFieldGetter());
            put("lastName", new LastNameFieldGetter());
            put("firstName", new FirstNameFieldGetter());
        }
    };
    private static SimpleHashtable<String, IComparisonOperator> operators = new SimpleHashtable<String, IComparisonOperator>(){
        {
            put("<", new LessThan());
            put("<=", new LessOrEquals());
            put(">", new GreaterThan());
            put(">=", new GreaterOrEquals());
            put("=", new Equals());
            put("!=", new Differs());
            put("LIKE", new LikeWildCard());
        }
    };

    private String recordField;
    private String value;
    private String operator;
    private Lexer lexer;

    private void query(Lexer lexer) {
        Token token;
        token = lexer.nextToken();
        if (!token.getType().equals(TokenType.ATTRIBUTE))
            throw new LexerException("query not correct");
        recordField = (String)token.getValue();
        token = lexer.nextToken();
        if (!token.getType().equals(TokenType.OPERATOR))
            throw new LexerException("query not correct");
        operator = (String)token.getValue();
        token = lexer.nextToken();
        if (!token.getType().equals(TokenType.VALUE))
            throw new LexerException("query not correct");
        value = (String)token.getValue();
    }

    public void ucitaj(StudentDatabase database)  throws IOException {
        CompositeConditional conditions = new CompositeConditional();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
        String input = reader.readLine();
        while (!input.equals("exit")) {
            lexer = new Lexer(input);
            Token token = lexer.nextToken();

            if (token.getType().equals(TokenType.INDEXQUERY)) {
                query(lexer);
                StudentRecord result = database.forJMBAG(value);
                printResults(new ArrayList<StudentRecord>(){{add(result);}});
            }
            else {
                conditions.removeAll();
                query(lexer);
                conditions.add(new ConditionalExpression(fields.get(recordField), value, operators.get(operator)));
                while (lexer.nextToken().getType().equals(TokenType.AND)) {
                    query(lexer);
                    conditions.add(new ConditionalExpression(fields.get(recordField), value, operators.get(operator)));
                }
                System.out.println();
                List<StudentRecord> results = database.filter(new QueryFilter(conditions));
                printResults(results);
            }

            input = reader.readLine();
        }
        System.out.println("Goodbye");
    }

    private void printHeaderFooter(String format1, String format2){
        System.out.printf(format1, "+============", "+=================", "+============");
        System.out.printf(format2, "+===+");
    }

    private void printResults(List<StudentRecord> results){
//        Object[] resultArray = results.toArray();
//        Arrays.sort(resultArray);
//        List<Object> res = Arrays.asList(resultArray);
        Iterator<StudentRecord> it = results.iterator();
        String format1 = "%-13s%-18s%-13s";
        String format2 = "%-5s%n";
        printHeaderFooter(format1, format2);
        while (it.hasNext()){
            StudentRecord student = it.next();
            System.out.printf(format1, "| " + student.getJmbag(), "| " + student.getLastName(), "| " + student.getFirstName());
            System.out.printf(format2, "| " + String.valueOf(student.getFinalGrade()) + " |");
        }
        printHeaderFooter(format1, format2);
        System.out.println("Records selected: " + String.valueOf(results.size()));
    }
}