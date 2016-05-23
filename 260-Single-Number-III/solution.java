public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int i = 0; i < nums.length; i++)
            diff ^= nums[i];
            
        diff &= -diff;
        
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++){
            if((diff & nums[i]) == 0)
                ans[0] ^= nums[i];
            else
                ans[1] ^= nums[i];
        }
        
        return ans;
    }
}