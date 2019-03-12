package sort;

import java.util.Arrays;
import java.util.Random;

public class testFiveSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        System.out.println("排序前:" + Arrays.toString(array));
        //selectSort(array);
        //insertSort(array);
        //bubbleSort(array);
        //heapSort(array);
        //quickSort(array);
        //mergeSort(array);
        //radixSort(array);
        //shellSort(array);

        System.out.println("排序后:" + Arrays.toString(array));
    }

    private static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }

    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.println(j);
                if (array[i] < array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] < array[j]) {
                    swap(array, j - 1, j);
                }
            }
        }
    }

    private static void shellSort(int[] array) {
        for (int i = array.length - 1 / 2; i > 0; i--) {
            for (int j = i; j < array.length; j++) {
                for (int k = j - i; k >= 0; k -= i) {
                    if (array[j] < array[k]) {
                        swap(array, k, i);
                    }
                }
            }
        }
    }

    private static void radixSort(int[] array) {
        int getMax = getMax(array);
        int maxLength = String.valueOf(getMax).length();
        int[][] bukket = new int[10][array.length];
        int[] count = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < array.length; j++) {
                int ys = array[j] / n % 10;
                bukket[ys][count[ys]++] = array[j];
            }
            int index = 0;
            for (int j = 0; j < count.length; j++) {
                if (count[j] != 0) {
                    for (int k = 0; k < count[j]; k++) {
                        array[index++] = bukket[j][k];
                    }
                    count[j] = 0;
                }
            }
        }
    }

    private static int getMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    private static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    //取出中值依此递归
    private static void mergeSort(int[] array, int low, int high) {
        int middle = (low + high) / 2;
        if (low < high) {
            mergeSort(array, low, middle);
            mergeSort(array, middle + 1, high);
            mergeSort(array, low, middle, high);
        }
    }

    private static void mergeSort(int[] array, int low, int middle, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = middle + 1;
        int index = 0;
        while (i <= middle && j <= high) {
            if (array[i] < array[j]) {
                temp[index] = array[i++];
            } else {
                temp[index] = array[j++];
            }
            index++;
        }
        while (j <= high) {
            temp[index++] = array[j++];
        }
        while (i <= middle) {
            temp[index++] = array[i++];
        }
        for (int k = 0; k < temp.length; k++) {
            array[k + low] = temp[k];
        }
    }

    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    //快速排序算法思想：1：依此取一个数组坐标的值，使得当前数组
    private static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int flag = array[start];
            int low = start;
            int high = end;
            while (low < high) {
                while (low < high && flag <= array[end]) {
                    high--;
                }
                array[low] = array[high];
                while (low < high && flag > array[low]) {
                    low++;
                }
                array[high] = array[low];
                array[low] = flag;
                quickSort(array, 0, low);
                quickSort(array, low + 1, end);
            }
        }
    }

    private static void heapSort(int[] array) {
        //最后一个子节点
        int start = (array.length - 1) / 2;
        //将每一个子数递归成一个大顶堆
        for (int i = start; i >= 0; i--) {
            heapSort(array, array.length, i);
        }
        //依此把大顶堆的最后以为取出，放到第一位，赋值给数组
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            heapSort(array, i, 0);
        }
    }

    private static void heapSort(int[] array, int size, int index) {
        int max = index;
        int leftNode = 2 * index + 1;
        int rightNode = 2 * index + 2;
        if (leftNode < size && array[max] < array[leftNode]) {
            max = leftNode;
        }
        if (rightNode < size && array[max] < array[rightNode]) {
            max = rightNode;
        }
        if (max != index) {
            swap(array, index, max);
            heapSort(array, size, max);
        }
    }

    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
