public class Solution {
    public int removeDuplicates(int[] nums) {
        int id = 0;
        for(int i = 0; i < nums.length; i++){
            while(i < nums.length && i+1 < nums.length && nums[i] == nums[i+1])
                i++;
            
            nums[id] = nums[i];
            id++;
        }
        
        return id;
    }
}