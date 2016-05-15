public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while(i < nums.length){
            while(nums[i] == nums[j] && i < nums.length)
                i++;
            j++;
            if(i < nums.length && j < nums.length){
                nums[j] = nums[i];
            }
            i++;
        }
        
        return i;
    }
}