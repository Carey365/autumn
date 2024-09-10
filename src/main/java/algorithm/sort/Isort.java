package algorithm.sort;

public interface Isort {

    void sort(int[] nums);

    default void sortHelper(int[] nums, int l, int r) {
        return;
    }

    default void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
