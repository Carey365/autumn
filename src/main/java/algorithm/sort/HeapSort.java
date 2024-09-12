package algorithm.sort;

/**
 * 堆排序
 */
public class HeapSort implements Isort{
    @Override
    public void sort(int[] nums) {
        for(int i=nums.length/2;i>=0;i--){
            sortHelper(nums,i,nums.length);
        }
    }

    @Override
    public void sortHelper(int[] nums, int index, int length) {
        int left = index*2+1;
        int right = index*2+2;
        int i = index;
        if(left<length && nums[left]<nums[i]){
            swap(nums,left,i);
            i = left;
        }
        if(right<length && nums[right]<nums[i]){
            swap(nums,right,i);
            i = right;
        }
        if(i != index){
            sortHelper(nums,i,length);
        }
    }
}
