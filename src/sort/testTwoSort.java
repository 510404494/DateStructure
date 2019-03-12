package sort;

import java.util.Arrays;
import java.util.Random;

public class testTwoSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[5];
        for (int i = 0; i <5 ; i++) {
            array[i] = random.nextInt(1000);
        }
        System.out.println("排序前："+ Arrays.toString(array));
        //radixSort(array);
        //quickSort(array);
        mergeSort(array);

        System.out.println("排序后："+ Arrays.toString(array));
    }

    private static void mergeSort(int[] array) {
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
    private static void mergeSort(int[] array, int low, int middle, int high) {
        int[] temp = new int[high-low+1];
        int i = low;
        int j = middle+1;
        int index = 0;
        while (i<=middle&&j<=high){
            if(array[i]<array[j]){
                temp[index] = array[i];
                i++;
            }else{
                temp[index] = array[j];
                j++;
            }
            index++;
        }
        while (j<=high){
            temp[index] = array[j];
            j++;
            index++;
        }
        while (i<=middle){
            temp[index] = array[i];
            i++;
            index++;
        }
        for (int k = 0; k <temp.length ; k++) {
            array[k+low] = temp[k];
        }
        System.out.println(low+"+++"+high+":------middle:"+middle+Arrays.toString(array));
    }

    private static void quickSort(int[] array) {
        quickSort(array,0,array.length-1);
    }

    /**
     *快速排序
     * @param array
     * @param start
     * @param end
     * 第一步：在start < end 的情况下取出第一个值，定义为选定值
     * 第二步：取出最小下标和最大下标
     * 第三部：先比较最后一个，如果大于flag就 换掉 如果小就flag就从第一个开始比较
     */
    private static void quickSort(int[] array, int start, int end) {
        if(start<end){
            int flag = array[start];
            int low = start;
            int high = end;
            while (low<high){
                while (low<high&&array[end]>=flag){
                    high--;
                }
                array[low] = array[high];
                while (low<high&&array[low]<=flag){
                    low++;
                }
                array[high]=array[low];
                array[low] = flag;
                quickSort(array,0,low);
                quickSort(array,low+1,end);
            }
        }
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
    private static void swap(int[] array,int x,int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
