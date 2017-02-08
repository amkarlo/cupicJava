package hr.fer.zemris.java.tecaj.hw5.collections;

import java.util.Iterator;

/**
 * Created by akarlovic on 7.2.2017..
 */
public class DemoHashTable {
    public static void main(String[] args){
        // create collection:
        SimpleHashtable<String, Integer> examMarks = new SimpleHashtable<>(2);

        // fill data:
        examMarks.put("Ivana", 2);
        examMarks.put("Ante", 2);
        examMarks.put("Jasna", 2);
        examMarks.put("Kristina", 5);
        examMarks.put("Ivana", 5);

        System.out.println(examMarks.toString());
        // overwrites old grade for Ivana
        // query collection:
         Integer kristinaGrade = examMarks.get("Kristina");
        System.out.println("Kristina's exam grade is: " + kristinaGrade); // writes: 5
        // What is collection's size? Must be four!
        System.out.println("Number of stored pairs: " + examMarks.size()); // writes: 4

        examMarks.remove("Ante");
        System.out.println(examMarks.toString());
        System.out.println("Number of stored pairs: " + examMarks.size()); // writes: 3
        examMarks.put("Ana", 5);
        examMarks.remove("Jasna");
        examMarks.put("Marija", 5);
        System.out.println(examMarks.toString());
        System.out.println("Number of stored pairs: " + examMarks.size()); // writes: 4

//        for(SimpleHashtable.TableEntry<String,Integer> pair1 : examMarks) {
//            for(SimpleHashtable.TableEntry<String,Integer> pair2 : examMarks) {
//                System.out.printf( "(%s => %d) - (%s => %d)%n",
//                        pair1.getKey(), pair1.getValue(),
//                        pair2.getKey(), pair2.getValue()
//                );
//            }
//        }

        Iterator<SimpleHashtable.TableEntry<String,Integer>> iter = examMarks.iterator();
        while(iter.hasNext()) {
            SimpleHashtable.TableEntry<String,Integer> pair = iter.next();
            if(pair.getKey().equals("Ivana")) {
                iter.remove();
            }
        }
        System.out.println(examMarks.toString());
        System.out.println("Number of stored pairs: " + examMarks.size()); // writes: 3



    }
}
