public class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] >= nums[lo]){
                if(nums[lo] <= target && target < nums[mid])
                    hi = mid-1;
                else
                    lo = mid+1;
            }
            else{//nums[mid] < nums[lo]
                if(nums[mid] < target && target <= nums[hi])
                    lo = mid+1;
                else
                    hi = mid-1;
            }
        }
        
        return nums[lo] == target? lo: -1;
    }
}