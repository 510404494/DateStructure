package sort;

import java.util.Arrays;
import java.util.Random;

public class threeSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[5];
        for (int i = 0; i <array.length ; i++) {
            array[i] = random.nextInt(1000);
        }
        System.out.println("排序前："+ Arrays.toString(array));
        //mergeSort(array);
        radixSort(array);
        System.out.println("排序后："+Arrays.toString(array));
    }

    private static void radixSort(int[] array) {
        int maxValue = getValue(array);
        int maxLength = String.valueOf(maxValue).length();
        int[][] bucket = new int[10][array.length];
        int[] count = new int[10];//为什么是10 -》因为对应桶的个数
        for (int i = 0,n=1; i <maxLength ; i++,n*=10) {
            for (int j = 0; j <array.length ; j++) {
                int ys = array[j]/n%10;
                bucket[ys][count[ys]] = array[j];
                count[ys]++;
            }
            int index = 0;
            for (int j = 0; j <count.length ; j++) {
                if(count[j]!=0){
                    for (int k = 0; k <count[j] ; k++) {
                        array[index++] = bucket[j][k];
                    }
                }
                count[j] = 0;//为什么要这一步？
            }
        }
    }

    private static int getValue(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i <array.length ; i++) {
            if(maxValue<array[i]){
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
                temp[index] = array[i++];
            }else{
                temp[index] = array[j++];
            }
            index++;
        }
        while (j<=high){
            temp[index++] = array[j++];
        }
        while (i<=middle){
            temp[index++] = array[i++];
        }
        for (int k = 0; k <temp.length ; k++) {
            array[low+k] = temp[k];
        }
    }


}
