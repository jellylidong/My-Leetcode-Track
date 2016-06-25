public class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo < hi){
            if(nums[lo] < nums[hi])
                return nums[lo];
                
            int mid = lo + (hi-lo)/2;
            
            if(nums[mid] >= nums[lo])
                lo = mid+1;
            else
                hi = mid;
            
        }
        
        return nums[lo];
    }
}