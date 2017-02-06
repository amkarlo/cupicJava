package hr.fer.zemris.java.custom.scripting.parser;

import hr.fer.zemris.java.custom.scripting.lexer.SmartLexerException;
import hr.fer.zemris.java.custom.scripting.lexer.SmartScriptLexer;
import hr.fer.zemris.java.custom.scripting.lexer.SmartToken;
import hr.fer.zemris.java.custom.scripting.lexer.SmartTokenType;
import hr.fer.zemris.java.custom.scripting.nodes.*;
import hr.fer.zemris.java.tecaj.hw2.EmptyStackException;
import hr.fer.zemris.java.tecaj.hw2.ObjectStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

/**
 * Created by akarlovic on 20.1.2017..
 */
public class SmartScriptParser {
    private SmartScriptLexer lexer;
    private DocumentNode documentNode;

    SmartScriptParser(String document){
        this.lexer = new SmartScriptLexer(document);
        parse();
    }

    public void parse(){
        ObjectStack graph = new ObjectStack();
        SmartToken token = new SmartToken();

        graph.push(this.documentNode);

        while (token.getType() != SmartTokenType.EOF){
            try{
                token = lexer.nextToken();

                if (token.getType().equals(SmartTokenType.TEXT))
                    graph.pop();

                if (graph.isEmpty())
                    throw new SmartScriptParserException("Too many end tags");

                Node graphNode = (Node)graph.pop();

                if (token.getType().equals(SmartTokenType.TEXT)){
                    graphNode.addChildNode(new TextNode(String.valueOf(token.getValue())));
                    graph.push(graphNode);
                }
                if (token.getType().equals(SmartTokenType.FOR)){
                    graphNode.addChildNode(new TextNode(String.valueOf(token.getValue())));
                    graph.push(graphNode);
                }


            }
            catch (SmartLexerException e){
                throw new SmartScriptParserException(e.getMessage());
            }
        }
    }

    public DocumentNode getDocumentNode(){
        return  this.documentNode;
    }



}
