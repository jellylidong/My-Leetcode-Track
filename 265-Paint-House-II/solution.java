public class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if(n == 0)
            return 0;
        int k = costs[0].length;
        if(k == 0)
            return 0;
            
        int[][] dp = new int[n][k];
        for(int i = 0; i < k; i++)
            dp[0][i] = costs[0][i];
            
        for(int i = 1; i < n; i++){
            int[] min = findMin(dp[i-1]);
            for(int j = 0; j < k; j++){
                dp[i][j] = costs[i][j] + min[j];
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++)
            min = Math.min(min, dp[n-1][i]);
            
        return min;
    }
    
    //the returned ans[i] is the min value in nums except nums[i]
    //don't use arrays.sort here to find the minimum two numbers
    //otherwise we can not meet the O(kn) complexity
    public int[] findMin(int[] nums){
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int pre = 0;
        int id = 0;
        for(int n: nums)
            min1 = Math.min(min1, n);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == min1){
                pre = nums[i];
                id = i;
                nums[i] = Integer.MAX_VALUE;
                break;
            }
        }
        for(int n: nums)
            min2 = Math.min(min2, n);
        nums[id] = pre;
        
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == min1)
                ans[i] = min2;
            else if(nums[i] == min2)
                ans[i] = min1;
            else
                ans[i] = min1;
        }
        return ans;
    }
}