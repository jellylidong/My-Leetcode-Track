public class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(nums[lo] == nums[hi])
                hi--;
            else if(nums[lo] < nums[hi])
                return nums[lo];
            else if(nums[lo] <= nums[mid])
                lo = mid+1;
            else
                hi = mid;
        }
        
        return nums[lo];
    }
}