package hr.fer.zemris.java.tecaj.hw5.db.lexer;

/**
 * Created by akarlovic on 20.1.2017..
 */
public class TokenValidResult {
    private boolean valid;
    private int move;
    private String symbol;

    TokenValidResult(boolean valid, int move, String symbol){
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
