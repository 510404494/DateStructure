package sort;

import java.util.Arrays;
import java.util.Random;

public class twoSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[6];
        for (int i = 0; i <6; i++) {
            array[i] = random.nextInt(900);
        }
        System.out.println("数组排序前:"+Arrays.toString(array));
        radixSort(array);
        System.out.println("数组排序后:"+Arrays.toString(array));
    }

    private static void radixSort(int[] array) {
        int maxValue = getMaxValue(array);
        int maxLength = String.valueOf(maxValue).length();
        int[][] bucket = new int[10][array.length];
        int[] count = new int[10];
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
                        array[index] = bucket[j][k];
                        index++;
                    }
                    count[j]=0;
                }
            }
        }

    }

    private static int getMaxValue(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <array.length ; i++) {
            if(max<array[i]){
                max=array[i];
            }
        }
        return max;
    }
}
