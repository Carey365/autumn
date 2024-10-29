package algorithm.array;

/**
 * 80. 删除有序数组中的重复项 II
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int slow = 0;
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                count++;
            }
            else{
                count = 1;
            }
            if(slow!=i){
                nums[slow]=nums[i];
            }
            if(count<=2){
                slow++;
            }
        }
        return slow;
    }
}
