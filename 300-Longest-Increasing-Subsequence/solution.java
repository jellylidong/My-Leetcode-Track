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
        for(int n: nums){
            int i = Arrays.binarySearch(dp, 0, len, n);
            if(i < 0)
                i = -(i+1);
            dp[i] = n;
            if(i == len)
                len++;
        }
        
        return len;
    }
}