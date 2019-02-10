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

    public static void quickSort(int[] a ,int low,int high){
        if(low>=high){return;}
        int[] b= a.clone();
        int index = low;
        int height = high;
        for (int i = index+1; i <height+1 ; i++) {
            if(a[index]>a[i]){
                b[low++] = a[i];
            }else{
                b[high--] = a[i];
            }
        }

        b[low]=a[index];
        quickSort(b,index,low-1);
        quickSort(b,low+1,a.length-1);
        //System.out.println(Arrays.toString(a));
    }

    private static void shellSort(int[] array) {
        //分组间隔
        for (int i =array.length/2; i >0 ; i/=2) {
            //分的组数
            for (int j = i; j <array.length ; j++) {
                System.out.println("JJJJJ#######"+j);
                //遍历分组数中的元素
                for (int k = j-i; k >=0 ; k-=i) {
                    System.out.println("KKKK===="+k);
                    if(array[k]>array[k+i]){
                        swap(array,k,k+i);
                    }
                }
                //System.out.println("*===="+Arrays.toString(array));
            }
            System.out.println("*===="+Arrays.toString(array));
            //break;
        }
    }
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[9];
        for (int i = 0; i <9 ; i++) {
            array[i] = random.nextInt(15);
        }
        System.out.println(Arrays.toString(array));
        //shellSort2(array);
        quickSort2(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void shellSort2(int[] array) {
        for (int i = array.length/2; i >0 ; i/=2) {
            for (int j = i; j <array.length ; j++) {
                for (int k = j-i; k >=0 ; k-=i) {
                    if(array[k]<array[k+i]){
                        swap(array,k,k+i);
                    }
                }
            }
        }
    }
    private static void quickSort2(int[] array,int start,int end){

        if(start<end){

            int falg = array[start];
            int low = start;
            int high = end;
            while (low<high){
                System.out.println("staty:="+start+",end="+end);
                while (low<high&&falg<=array[end]){
                    high--;
                }
                array[low]=array[high];
                while (low<high&&array[low]<=falg){
                    low++;
                }
                array[high]=array[low];
                array[low]=falg;
                //break;
                quickSort2(array,0,low);
                quickSort2(array,low+1,end);
            }

        }

    }


    private static void swap(int[] x, int a, int b) {
        int t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
