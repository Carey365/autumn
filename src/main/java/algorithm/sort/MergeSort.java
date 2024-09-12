package algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort implements Isort{
    @Override
    public void sort(int[] nums) {
        int[] temp = new int[nums.length];
        mergeHelper(nums, temp, 0, nums.length - 1);
    }

    public void mergeHelper(int[] nums, int[] temp, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeHelper(nums, temp, l, mid);
        mergeHelper(nums, temp, mid + 1, r);
        int m = l;
        int n = mid + 1;
        int index = l;
        while (m <= mid && n <= r) {
            if (nums[m] <= nums[n]) {
                temp[index++] = nums[m++];
            } else {
                temp[index++] = nums[n++];
            }
        }
        while (m <= mid) {
            temp[index++] = nums[m++];
        }
        while (n <= r) {
            temp[index++] = nums[n++];
        }
        for (int i = l; i <= r; i++) {
            nums[i] = temp[i];
        }
    }
}
