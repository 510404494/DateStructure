package sort;

import java.util.Arrays;
import java.util.Random;

public class testTwoSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i <10 ; i++) {
            array[i] = random.nextInt(1000);
        }
        System.out.println("排序前："+ Arrays.toString(array));
        radixSort(array);
        System.out.println("排序后："+ Arrays.toString(array));
    }

    /**
     *
     * @param array
     * 第一步：求出最大值
     * 第二步：求出最大值的长度
     * 第三步：创建一个桶的二维数组和一个创建一个记录每个桶放置数量的的数组
     * 第五步：把个位，十位，百位的余数放进桶中，并且记录每个桶放置的数量
     * 第六步：根据桶的放置数量把桶中的数依此覆盖原来的数组
     */
    private static void radixSort(int[] array) {
        int maxValue = getMaxValue(array, Integer.MIN_VALUE);
        int maxLength = String.valueOf(maxValue).length();
        int[][] bucker = new int[10][array.length];
        int[] count = new int[10];
        for (int i = 0,n=1; i <maxLength ; i++,n*=10) {
            for (int j = 0; j <array.length ; j++) {
                int ys = array[j]/n%10;
                bucker[ys][count[ys]] = array[j];
                count[ys]++;
            }
            int index = 0;
            for (int j = 0; j <count.length ; j++) {
                if(count[j]!=0){
                    for (int k = 0; k <count[j] ; k++) {
                        array[index] = bucker[j][k];
                        index++;
                    }
                }
                count[j]=0;
            }
        }
    }

    private static int getMaxValue(int[] array, int maxValue) {
        for (int i = 0; i <array.length ; i++) {
            if(maxValue<array[i]){
                maxValue = array[i];
            }
        }
        return maxValue;
    }
}
