package com.wsmhz.dataStructure.binarySearchTree;

import java.util.ArrayList;
import java.util.Random;

/**
 * create by tangbj on 2018/10/31
 */
public class BinarySearchTreeTest {

    public static void main(String[] args) {
//        int[] num = {5,3,6,8,4,2};
//        BinarySearchTree root = new BinarySearchTree();
//        for (int i : num) {
//            root.add(i);
//        }
//        root.preOrder();
//        System.out.println();

//        root.preOrderNR();
//        System.out.println();

//        root.inOrder();
//        System.out.println();

//        root.postOrder();
//        root.levelOrder();

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < bst.getSize(); i++) {
            arrayList.add(bst.removeMin());
        }
        System.out.println(arrayList);
        for (int i = 1; i < arrayList.size(); i++) {
            if(arrayList.get(i-1) > arrayList.get(i)){
                throw new IllegalArgumentException("error");
            }
        }
        System.out.println("completed");

        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
        for (int i = 0; i < n; i++) {
            bst2.add(random.nextInt(10000));
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i = 0; i < bst2.getSize(); i++) {
            arrayList2.add(bst2.removeMax());
        }
        System.out.println(arrayList2);
        for (int i = 1; i < arrayList2.size(); i++) {
            if(arrayList2.get(i-1) < arrayList2.get(i)){
                throw new IllegalArgumentException("error");
            }
        }
        System.out.println("completed");
    }
}
