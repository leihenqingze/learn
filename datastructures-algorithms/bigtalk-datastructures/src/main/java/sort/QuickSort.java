package sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        //当前待排序的序列最小下标值bow和最大下标值high
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] numbers, int low, int high) {
        int pivot;
        if (low < high) {
            /*拆分,算出枢轴值*/
            pivot = partition(numbers, low, high);
            sort(numbers, low, pivot - 1);
            sort(numbers, pivot + 1, high);
        }
    }

    /*交换顺序表numbers中子表的记录,使枢轴记录到位,并返回其所在位置./
	/*此时在它之前(后)的记录均不大(小)于它。*/
    private static int partition(int[] numbers, int low, int high) {
        /*用子表的第一个记录作枢轴记录*/
        int pivotkey = numbers[low];
        /*从表的两端交替向中间扫描*/
        while (low < high) {
            /*将比枢轴记录小的记录交换到低端*/
            while (low < high && numbers[high] >= pivotkey) {
                high--;
            }
            Utils.swap(numbers, low, high);
            /*将比枢轴记录大的记录交换到高端*/
            while (low < high && numbers[low] <= pivotkey) {
                low++;
            }
            Utils.swap(numbers, low, high);
        }
        /*返回枢轴所在位置*/
        return low;
    }

}
