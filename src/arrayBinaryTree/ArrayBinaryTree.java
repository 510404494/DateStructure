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

    /**
     *
     * @param array
     * 1.使得每个子树都是一个大顶堆
     * 2.使得数组递归组成一个大顶堆（大顶堆，树形结构，一次往上递增）
     * 3.依此取值最大值，使得去掉最大值的数组在组成arr【n-1】的大顶堆
     * ，把最大的放到最后以为->组成排序好的数组
     */
    public   void creatMaxHeap(int[] array) {
        int start=(array.length-1)/2;
        for (int i = start; i >=0; i--) {
            System.out.println("i="+i+":"+ Arrays.toString(array));
            creatMaxHeap(array,array.length,i);
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
        System.out.println("max:"+max+"-leftNode:"+leftNode+"-rightNode:"+rightNode);

        if(leftNode<size&&arr[max]<arr[leftNode]){
            max=leftNode;
        }
        if(rightNode<size&&arr[max]<arr[rightNode]){
            max = rightNode;
        }
        System.out.println("max:"+max);
        if(max!=index){
            swap(arr,index,max);
            System.out.println("index:"+index+"---size:"+size+"---Arr:="+Arrays.toString(arr));
            creatMaxHeap(arr,size,max);
        }

    }
    private static void swap(int[] array,int x,int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] =temp;
    }


}
