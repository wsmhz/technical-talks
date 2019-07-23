package com.wsmhz.dataStructure.set;

import com.wsmhz.dataStructure.set.impl.BinarySearchTreeSet;
import com.wsmhz.resources.FileOperation;

import java.util.ArrayList;

/**
 * create by tangbj on 2018/11/10
 */
public class BinarySearchTreeSetTest {

    public static void main(String[] args) {
        System.out.println("*********BinarySearchTreeSet********");
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile(FileOperation.pride_and_prejudice, words1)) {
            System.out.println("Total words: " + words1.size());

            BinarySearchTreeSet<String> set1 = new BinarySearchTreeSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile(FileOperation.a_tale_of_two_cities, words2)){
            System.out.println("Total words: " + words2.size());

            BinarySearchTreeSet<String> set2 = new BinarySearchTreeSet<>();
            for(String word: words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }
        System.out.println("*********BinarySearchTreeSet********");

    }
}
