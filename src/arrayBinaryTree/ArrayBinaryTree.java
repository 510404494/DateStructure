package arrayBinaryTree;

import java.util.Arrays;

public class ArrayBinaryTree {
    int[] data;
    public ArrayBinaryTree(int[] data){
        this.data = data;
    }


    public void frontShow() {
        frontShow(0);
    }

    private void frontShow(int index) {
        if(data.length==0||data==null){
            return;
        }else{
            System.out.println(data[index]);
            if(2*index+1<data.length){
                frontShow(2*index+1);
            }
            if(2*index+2<data.length){
                frontShow(2*index+2);
            }
        }
    }
    public   void creatMaxHeap(int[] array) {
        int start=(array.length-1)/2;
        for (int i = start; i >=0; i--) {
            creatMaxHeap(array,array.length,i);
            System.out.println("i="+i+":"+ Arrays.toString(array));
        }
        int j=0;
        for (int i = array.length-1; i >0 ; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i]=temp;
            j++;
            System.out.println("j="+j+":"+Arrays.toString(array));
            creatMaxHeap(array,i,0);
        }
    }
    public void creatMaxHeap(int[] arr,int size,int index){
        int max = index;
        int leftNode = 2*index+1;
        int rightNode = 2*index+2;
        if(leftNode<size&&arr[max]<arr[leftNode]){
            max=leftNode;
        }
        if(rightNode<size&&arr[max]<arr[rightNode]){
            max = rightNode;
        }
        if(max!=index){
            swap(arr,index,max);
            creatMaxHeap(arr,size,max);
        }

    }
    private static void swap(int[] array,int x,int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] =temp;
    }


}
