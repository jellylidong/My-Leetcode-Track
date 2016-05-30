public class Solution {
    
    //O(n^2)
    // public int lengthOfLIS(int[] nums) {
    //     int len = nums.length;
    //     if(len == 0)
    //         return 0;
            
    //     //count[i] is the max length of suquence end with nums[i], inclusive    
    //     int[] count = new int[len];
    //     Arrays.fill(count, 1);
        
    //     int lo = 0;
    //     int hi = 0;
        
    //     while(hi < len){
    //         while(lo < hi){
    //             if(nums[lo] < nums[hi]){
    //                 count[hi] = Math.max(count[lo]+1, count[hi]);
    //             }
    //             lo++;
    //         }
    //         lo = 0;
    //         hi++;
    //     }
        
    //     int ans = 0;
    //     for(int n: count)
    //         ans = Math.max(ans, n);
            
    //     return ans;
    // }
    
    
    //O(nlgn)
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int[] dp = new int[len];
        len = 0;
        for(int n: nums){
            //serch the insert position in dp for each number of nums, 
            int i = Arrays.binarySearch(dp, 0, len, n);
            if(i < 0)
                i = -(i+1);
            //insert current number to dp
            dp[i] = n;
            
            //update len when current number is inserted into the tail of dp
            if(i == len)
                len++;
        }
        
        return len;
    }
}