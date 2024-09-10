package algorithm.sort;

/**
 * 快速排序
 */
public class QuickSort implements Isort {

    @Override
    public void sort(int[] nums) {
        sortHelper(nums, 0, nums.length - 1);
    }

    @Override
    public void sortHelper(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int target = nums[l];
        int index = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < target) {
                swap(nums, i, index);
                index++;
            }
        }
        sortHelper(nums, l, index - 1);
        sortHelper(nums, index + 1, r);
    }
}

