package sort;

import java.util.Arrays;
import java.util.Random;

public class testOneSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i <10 ; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println("排序前："+Arrays.toString(array));
        //shellSort(array);
        quickSort(array);
        System.out.println("排序后："+Arrays.toString(array));
    }

    private static void quickSort(int[] array) {
        quickByInsert(array,0,array.length-1);
    }

    private static void quickByInsert(int[] array,int start,int end) {
        if(start<end){
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
                quickByInsert(array,0,low);
                quickByInsert(array,low+1,end);
            }
        }
    }

    private static void shellSort(int[] array) {
        for (int i = array.length/2; i >0 ; i/=2) {
            for (int j = i; j <array.length ; j++) {
                for (int k = j-i; k >=0 ; k-=i) {
                    if(array[k]>array[j]){
                        swap(array,k,j);
                    }
                }
            }
        }
    }
    private static void swap(int[] array,int x,int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

}
