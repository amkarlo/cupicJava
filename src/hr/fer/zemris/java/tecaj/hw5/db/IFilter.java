package hr.fer.zemris.java.tecaj.hw5.db;

/**
 * Created by akarlovic on 8.2.2017..
 */
public interface IFilter {
    public boolean accepts(StudentRecord record);
}
