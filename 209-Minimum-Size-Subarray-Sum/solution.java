public class Solution {
    // public int minSubArrayLen(int s, int[] nums) {
    //     int i = 0; 
    //     int j = 0;
    //     int sum = 0;
    //     int len = Integer.MAX_VALUE;
        
    //     for(i = 0; i < nums.length; i++){
    //         sum += nums[i];
    //         while(sum >= s && j <= i){
    //             sum -= nums[j++];
    //             len = Math.min(len, i-j+1+1);
    //         }
            
            
    //         // System.out.println(i + " " + j);
    //     }
        
    //     return len == Integer.MAX_VALUE?  0: len;
    // }
    
    
    //above is O(n) method
    //following is O(nlgn) method
    //the given array is not sorted so it's not possible to binary search
    //but note all numbers are positive, so the range sum is sorted
    //sum[i] is th sum of nums[0, ... i], both inclusive
     public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int[] sums = new int[len+1];
        sums[0] = 0;
        for(int i = 0; i < nums.length; i++){
            sums[i+1] = nums[i] + sums[i];
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < sums.length; i++){
            //for each sum[i], we need to search sums[i+1 ... len-1]
            //the range sum is sums[j] - sums[i], (j = i+1, i+2 ... len-1)
            //to save time we search s + sum[i] instead so that we don't have to reduce sums[i] for each sums[j]
            int end = search(sums, i+1, len, s+sums[i]);
            //binary search will return the index if find the number
            //if not find, will return the insert position
            
            
            if(end == sums.length) break; // invalid end, break;
            
            ans = Math.min(ans, end-i);
        }
        
        return ans == Integer.MAX_VALUE? 0: ans;
     }
     
     
     public int search(int[] sums, int lo, int hi, int target){
         //need to consider the single number, so must be while(lo <= hi)
         while(lo <= hi){
             int mid = lo + (hi-lo)/2;
             if(sums[mid] >= target)
                hi = mid-1;
            else
                lo = mid+1; // lo is also used as insertion position if not found, the sums[mid] == target must be in (change hi part) 
         }
         return lo;
     }
}