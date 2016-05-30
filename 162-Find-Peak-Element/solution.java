public class Solution {
    public int findPeakElement(int[] nums) {
        // if(nums.length == 0)
        //     return -1;
        // if(nums.length == 1)
        //     return 0;
            
        // for(int i = 1; i < nums.length-1; i++){
        //     if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
        //         return i;
        // }
        
        // if(nums[0] > nums[1])
        //     return 0;
        // if(nums[nums.length-1] > nums[nums.length-2])
        //     return nums.length-1;
            
        // return -1;
        
        //above code works but uses O(n)
        //the problem actually requires us to find a local max value
        //so we can use binary search to find a local max, which is O(lgn)
        
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo < hi){
            int mid1 = lo + (hi-lo)/2;
            int mid2 = mid1 + 1;
            if(nums[mid1] > nums[mid2])
                hi = mid1;
            else
                lo = mid2;
        }
        
        return lo;
    }
}