package sort;


import java.util.Arrays;
import java.util.Random;

public class Sort {
    public static int [] bubbleSort(int[] array){
        int num = 0;
        for (int i = 1; i <array.length ; i++) {
            boolean flag = true;
            for (int j = 0; j <array.length-1 ; j++) {
                num++;
                int a = array[j];
                int b = array[j+1];
                if(a>b){
                    array[j] = b;
                    array[j+1] = a;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
            System.out.print("第"+i+"轮排序后的结果为:");
            System.out.println(Arrays.toString(array));
            System.out.println("第"+num);
        }
        return array;
    }

    public static int[] choisSort(int[] array){
        for (int i = 0; i <array.length-1 ; i++) {
            int min = i;
            for (int j = i+1; j <array.length ; j++) {
                if(array[j]<array[min]){
                    min = j;
                }
            }
            if(min!=i){
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
            System.out.print("第"+(i+1)+"轮排序后的结果为:");
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    public static int[] insertSort(int[] array){
        int j;
        for (int i = 1; i <array.length ; i++) {
            int tmp = array[i];
            j = i;
            while (j>0&&tmp<array[j-1]){
                array[j]=array[j-1];
                j--;
            }
            array[j] = tmp;
            System.out.print("第"+(i)+"轮排序后的结果为:");
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[15];
        for (int i = 0; i <15 ; i++) {
            array[i] = random.nextInt(100);
        }
        //array = bubbleSort(array);
        //array = choisSort(array);
        array = insertSort(array);
        System.out.println(Arrays.toString(array));

    }
}
