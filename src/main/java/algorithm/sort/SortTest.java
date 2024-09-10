package algorithm.sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,5,3,2};
        //快速排序
        QuickSort quickSort = new QuickSort();
        //冒泡排序
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(nums);
        Arrays.sort(nums);
        for (int num: nums){
            System.out.println(num);
        }
    }
}
