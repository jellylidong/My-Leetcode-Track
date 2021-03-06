public class Solution {
    public int search(int[] nums, int target) {
        // int lo = 0;
        // int hi = nums.length-1;
        
        // while(lo < hi){
        //     int mid = lo + (hi-lo)/2;
        //     if(nums[mid] == target)
        //         return mid;
            
        //     //one of the two branches must cover == target
        //     //[3,1], 1
        //     //mid can == lo
        //     if(nums[mid] >= nums[lo]){
        //         if(nums[lo] <= target && target < nums[mid])
        //             hi = mid-1;
        //         else
        //             lo = mid+1;
        //     }
        //     else{//nums[mid] < nums[lo]
        //         if(nums[mid] < target && target <= nums[hi])
        //             lo = mid+1;
        //         else
        //             hi = mid-1;
        //     }
        // }
        
        // return nums[lo] == target? lo: -1;
        
        //just type again
        //take care of the case there are only two numbers in the array
        
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            
            if(nums[mid] == target)
                return mid;
            
            if(nums[lo] <= nums[mid]){
                if(nums[lo] <= target && target < nums[mid])
                    hi = mid-1;
                else
                    lo = mid+1;
            }
            else{
                if(nums[mid] < target && target <= nums[hi])
                    lo = mid+1;
                else
                    hi = mid-1;
            }
            
            
        }
        return nums[lo] == target? lo:-1;
    }
}