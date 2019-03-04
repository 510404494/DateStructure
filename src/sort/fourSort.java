package sort;

import java.util.Arrays;
import java.util.Random;


public class fourSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i <array.length ; i++) {
            array[i]=random.nextInt(1000);
        }
        System.out.println("排序前："+ Arrays.toString(array));
        //mergeSort(array);
        //radixSort(array);
        //quickSort(array);
        //shellSort(array);
        //insertSort(array);
        //selectSort(array);
        //bubbleSort(array);
        heapSort(array);


        System.out.println("排序后："+Arrays.toString(array));
    }

    private static void heapSort(int[] array) {
        int start = (array.length-1)/2;
        for (int i = start; i>=0 ; i--) {
            heapSort(array,array.length,i);
        }
        for (int i = array.length-1; i >0 ; i--) {
            swap(array,0,i);
            heapSort(array,i,0);
        }
    }

    private static void heapSort(int[] array, int size, int index) {
        int leftNode = 2*index+1;
        int rightNode =2*index+2;
        int max = index;
        if(leftNode<size&&array[leftNode]>array[max]){
            max = leftNode;
        }
        if(rightNode<size&&array[rightNode]>array[max]){
            max = rightNode;
        }
        if(max!=index){
            swap(array,index,max);
            heapSort(array,size,max);
        }
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i <array.length-1 ; i++) {
            for (int j = 1; j <array.length-i ; j++) {
                if(array[j-1]>array[j]){
                    swap(array,j-1,j);
                }
            }
        }
    }

    private static void selectSort(int[] array) {
        for (int i = 0; i <array.length-1 ; i++) {
            for (int j = 0; j <array.length ; j++) {
                if(array[i]<array[j]){
                    swap(array,i,j);
                }

            }

        }
    }

    private static void insertSort(int[] array) {
        for (int i = 0; i <array.length ; i++) {
            for (int j = i; j >0 ; j--) {
                if(array[j-1]>array[j]){
                    swap(array,j-1,j);
                }
            }
        }
    }

    private static void shellSort(int[] array) {
        for (int n = array.length; n >=1 ; n/=2) {
            for (int i = 0; i <array.length ; i++) {
                for (int j = n+i; j <array.length ; j++) {
                    if(array[i]>array[j]){
                        swap(array,i,j);
                    }
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void quickSort(int[] array) {
        quickSort(array,0,array.length-1);
    }

    private static void quickSort(int[] array, int start, int end) {
        if(start<end){
            int flag = array[start];
            int low = start;
            int high = end;
            while (low<high){
                while (low<high&&flag<=array[end]){
                    high--;
                }
                array[low] = array[high];
                while (low<high&&flag>=array[low]){
                    low++;
                }
                array[high] = array[low];
                array[low] = flag;
                quickSort(array,0,low);
                quickSort(array,low+1,high);
            }
        }
    }

    private static void radixSort(int[] array) {
        int maxValue = getMaxValue(array);
        int maxLength = String.valueOf(maxValue).length();
        int[][] bucket = new int[10][array.length];
        int[] counts = new int[10];
        for (int i = 0,n=1; i <maxLength ; i++,n*=10) {
            for (int j = 0; j <array.length ; j++) {
                int ys = array[j]/n%10;
                bucket[ys][counts[ys]++] = array[j];
            }
            int index = 0;
            for (int j = 0; j <counts.length ; j++) {
                if(counts[j]!=0){
                    for (int k = 0; k <counts[j] ; k++) {
                        array[index++] = bucket[j][k];
                    }
                }
                counts[j]=0;
            }
        }
    }

    private static int getMaxValue(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i <array.length ; i++) {
            if(maxValue<=array[i]){
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    private static void mergeSort(int[] array) {
        mergeSort(array,0,array.length-1);
    }

    private static void mergeSort(int[] array, int low, int high) {
        int middle = (low+high)/2;
        if(low<high){
            mergeSort(array,low,middle);
            mergeSort(array,middle+1,high);
            mergeSort(array,low,middle,high);
        }
    }

    private static void mergeSort(int[] array, int low, int middle, int high) {
        int[] temp = new int[high-low+1];
        int i = low;
        int j = middle+1;
        int index = 0;
        while (i<=middle&&j<=high){
            if(array[i]<array[j]){
                temp[index++] = array[i++];
            }else{
                temp[index++] = array[j++];
            }
        }
        while (i<=middle){
            temp[index++] = array[i++];
        }
        while (j<=high){
            temp[index++] = array[j++];
        }
        for (int k = 0; k <temp.length ; k++) {
            array[low+k]=temp[k];
        }
    }
}
