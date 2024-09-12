package algorithm.sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,5,3,2,8,0};
        //快速排序
        QuickSort quickSort = new QuickSort();
        //冒泡排序
        BubbleSort bubbleSort = new BubbleSort();
        //堆排序
        HeapSort heapSort = new HeapSort();
        //归并排序
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(nums);
        Arrays.sort(nums);
        for (int num: nums){
            System.out.println(num);
        }
    }
}
