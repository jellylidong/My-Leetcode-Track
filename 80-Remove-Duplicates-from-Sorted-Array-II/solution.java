public class Solution {
    public int removeDuplicates(int[] nums) {
        int lo = 0;
        int hi = 0;
        
        while(hi < nums.length){
            int count = 1;
            while(hi < nums.length-1 && nums[hi] == nums[hi+1]){
                hi++;
                count++;
            }
            
            for(int j = 0; j < 2 && j < count; j++){
                nums[lo] = nums[hi];
                lo++;
            }
            
            
            hi++;
            
        }
        
        return lo;
    }
}