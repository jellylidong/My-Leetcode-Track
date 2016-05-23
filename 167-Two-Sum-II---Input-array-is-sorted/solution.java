public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = {-1, -1};
        int lo = 0;
        int hi = nums.length-1;
        
        while(nums[lo] + nums[hi] != target && lo < hi){
            if(nums[lo] + nums[hi] < target)
                lo++;
            else if(nums[lo] + nums[hi] > target)
                hi--;
            else
                break;
        }
        
        ans[0] = lo+1;
        ans[1] = hi+1;
        
        return ans;
    }
}