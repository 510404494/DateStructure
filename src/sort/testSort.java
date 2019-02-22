package sort;

import java.util.Arrays;
import java.util.Random;

public class testSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[9];
        for (int i = 0; i <9 ; i++) {
            array[i] = random.nextInt(1000);
        }
        System.out.println("排序数组："+Arrays.toString(array));
        //冒泡排序
        //bubbleSort(array);
        //选择排序
        //selectSort(array);
        //插入排序
        //insertSort(array);
        //快速排序--
        //quickSort(array,0,array.length-1);
        //希尔排序--
        //shellSort(array);
        //基数排序--
        //radixSort(array);
        //归并排序
        //mergeSort(array);
        //堆排序
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void heapSort(int[] array) {
        int start=(array.length-1)/2;
        for (int i = start; i >=0; i--) {
            heapSort(array,array.length,i);
        }
        for (int i = array.length-1; i >0 ; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i]=temp;
            heapSort(array,i,0);
        }
    }
    private static void heapSort(int[] array,int size,int index) {
        int leftNode = 2*index+1;
        int rightNode = 2*index+2;
        int max = index;
        if (leftNode<size&&array[leftNode] > array[max]) {
            max=leftNode;
        }
        if(rightNode<size&&array[rightNode]>array[max]){
            max=rightNode;
        }
        if(max!=index){
            swap(array,index,max);
            heapSort(array,size,max);
        }
    }
    private static void mergeSort(int[] array){
        mergeSort(array,0,array.length-1);
    }
    private static void mergeSort(int[] array,int low,int high){
        int midle=(high+low)/2;
        if(low<high){
            mergeSort(array,low,midle);
            mergeSort(array,midle+1,high);
            mergeSort(array,low,midle,high);
        }
    }
    private static void mergeSort(int[] array,int low,int middle,int high) {
        int[] temp = new int[high-low+1];
        int i = low;
        int j = middle+1;
        int index = 0;
        while (i<=middle&&j<=high) {
            if (array[i] < array[j]) {
                temp[index] = array[i];
                i++;
            } else {
                temp[index] = array[j];
                j++;
            }
            index++;
        }
        //处理多余的数据
        while (j<=high){
            temp[index]=array[j];
            j++;
            index++;
        }
        while (i<=middle){
            temp[index]=array[i];
            i++;
            index++;
        }
        for (int k = 0; k < temp.length; k++) {
            array[k+low]=temp[k];
        }

    }
    private static void radixSort(int[] array) {
        //取出最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <array.length ; i++) {
            if(array[i]>max){
                max=array[i];
            }
        }
        //计算最大数是几位数
        int maxLength =String.valueOf(max).length();
        //放入桶中
        int[][]  tmp = new int [10][array.length];
        //用于记录在相应的数组中存放数字的数量
        int[] counts = new int[10];
        //根据最大长度比较次数
        for (int i = 0,n= 1; i <maxLength ; i++,n*=10) {
            //把没一个数据分别计算余数
            for (int j = 0; j <array.length ; j++) {
                //计算余数
                int ys = array[j]/n%10;
                tmp[ys][counts[ys]] = array[j];
                counts[ys]++;
            }
            int index = 0;
            for (int j = 0; j <counts.length ; j++) {
                if(counts[j]!=0){
                    for (int k = 0; k <counts[j] ; k++) {
                        array[index]=tmp[j][k];
                        index++;
                    }
                    counts[j]=0;
                }
            }
        }
    }
    private static void shellSort(int[] array){
        for (int i = array.length/2; i >0; i/=2) {
            for (int j = i; j <array.length ; j++) {
                for (int k = j-i; k >=0 ; k-=i) {
                    if(array[j]<array[k]){
                        swap(array,j,k);
                    }
                }
            }
        }
    }
    private static void quickSort(int[] array,int start,int end){
        if (start<end) {
            int flag = array[start];
            int low =start;
            int high = end;
            while (low<high){
                while (low<high&&flag<=array[end]){
                    high--;
                }
                array[low] = array[high];
                while (low<high&&array[low]<=flag){
                    low++;
                }
                array[high]=array[low];
                array[low]=flag;
                quickSort(array,0,low);
                quickSort(array,low+1,end);
            }
        }
    }
    private static void insertSort(int[] array){
        for (int i = 0; i <array.length; i++) {
            for (int j = i; j >0 ; j--) {
                if(array[j-1]>array[j]){
                    swap(array,j-1,j);
                }
            }
        }
    }
    private static void bubbleSort(int[] array) {
        for (int i = 0; i <array.length-1 ; i++) {
            for (int j = 1; j < array.length-i; j++) {
                if(array[j-1]>array[j]){
                    swap(array,j-1,j);
                }
            }
        }
    }
    private static void selectSort(int[] array){
        for (int i = 0; i <array.length-1 ; i++) {
            for (int j = i+1; j <array.length ; j++) {
                if(array[j]<array[i]){
                    swap(array,j,i);
                }
            }
        }
    }
    private static void swap(int[] array,int x,int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] =temp;
    }
}
