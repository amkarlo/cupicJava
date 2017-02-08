package hr.fer.zemris.java.tecaj.hw5.db;

/**
 * Created by akarlovic on 8.2.2017..
 */
public class QueryFilter implements IFilter {

    QueryFilter(String input){
        
    }

    @Override
    public boolean accepts(StudentRecord record) {
        return false;
    }
}
