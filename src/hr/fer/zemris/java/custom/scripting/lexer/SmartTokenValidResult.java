package hr.fer.zemris.java.custom.scripting.lexer;

/**
 * Created by akarlovic on 1.2.2017..
 */
public class SmartTokenValidResult {
    private boolean valid;
    private int move;
    private String symbol;

    public SmartTokenValidResult(boolean valid, int move, String symbol){
        this.valid = valid;
        this.move = move;
        this.symbol = symbol;
    }

    public boolean isValid() {
        return valid;
    }

    public int getMove() {
        return move;
    }

    public String getSymbol() {
        return symbol;
    }
}
