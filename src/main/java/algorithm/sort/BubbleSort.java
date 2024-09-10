package algorithm.sort;

/**
 * 冒泡排序
 */
public class BubbleSort implements Isort{
    @Override
    public void sort(int[] nums) {
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }
}
