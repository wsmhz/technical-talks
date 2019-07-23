package com.wsmhz.dataStructure.set;

import com.wsmhz.dataStructure.set.impl.BinarySearchTreeSet;
import com.wsmhz.resources.FileOperation;
import com.wsmhz.dataStructure.set.impl.LinkedListSet;

import java.util.ArrayList;

/**
 * create by tangbj on 2018/11/10
 */
public class SetTest {

    private static double testSet(Set<String> set, String filename){

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        String filename = "E:\\intelliJ_IDEA\\wsmhz-algorithm-dataStructure\\src\\com\\wsmhz\\dataStructure\\set\\pride-and-prejudice.txt";

        BinarySearchTreeSet<String> bstSet = new BinarySearchTreeSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: " + time1 + " s");

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("Linked List Set: " + time2 + " s");

    }
}
