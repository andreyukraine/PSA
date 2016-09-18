package ua.artcode.test;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Created by serhii on 9/17/16.
 */
public class TestNavigableSet {

    public static void main(String[] args) {
        NavigableSet<String> navSet = new TreeSet<>();
        navSet.add("Ivan");
        navSet.add("Kolia");
        navSet.add("Odessa");
        navSet.add("Olga");


        NavigableSet<String> relevant = navSet.tailSet("Ol", true);
        relevant.stream().limit(10).forEach(System.out::println);



    }
}
