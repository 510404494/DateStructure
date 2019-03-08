package arrayBinaryTree;

import java.util.Arrays;
import java.util.Random;

public class ArrayTreeTest {
    public static void main(String[] args) {
        Random random = new Random();
        int[] data = new int[10];
        for (int i = 0; i <10 ; i++) {
            data[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(data));
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(data);
        arrayBinaryTree.frontShow();
        System.out.println("========================");
        int start =(data.length-1)/2;
        System.out.println("start:"+start);
        System.out.println("data.length:"+data.length);
        arrayBinaryTree.creatMaxHeap(data);
        System.out.println(Arrays.toString(data));
    }
}
