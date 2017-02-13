package hr.fer.zemris.java.tecaj.hw6.demo2;

import java.util.Optional;

/**
 * Created by akarlovic on 13.2.2017..
 */
public class MedianDemo1 {
    public static void main(String[] args){
        LikeMedian<Integer> likeMedian = new  LikeMedian<Integer>();
        likeMedian.add(new Integer(10));
        likeMedian.add(new Integer(5));
        likeMedian.add(new Integer(3));
        likeMedian.add(new Integer(4));
        Optional<Integer> result = likeMedian.get();
        System.out.println(result);
        for(Integer elem : likeMedian) {
            System.out.println(elem);
        }

    }
}
