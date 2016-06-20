public class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2)
            return 0;
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        for(int n: nums){
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        
        int size = (max-min)/(nums.length-1);
        int[] maxs = new int[nums.length-1];
        int[] mins = new int[nums.length-1];
        Arrays.fill(maxs, Integer.MIN_VALUE);
        Arrays.fill(mins, Integer.MAX_VALUE);
        
        for(int i = 0; i < nums.length; i++){
            int id = (nums[i]-min)/size;
            maxs[id] = Math.max(maxs[i], nums[i]);
            mins[id] = Math.min(mins[i], nums[i]);
        }
        
        int ans = 0;
        if(maxs[0] != Integer.MIN_VALUE && mins[0] != Integer.MAX_VALUE)
            ans = maxs[0] - mins[0];
        for(int i = 1; i < nums.length-1; i++){
            if(maxs[i] != Integer.MIN_VALUE && mins[i] != Integer.MAX_VALUE)
                ans = Math.max(ans, maxs[i] - mins[i]);
            if(mins[i] != Integer.MAX_VALUE && maxs[i-1] != Integer.MIN_VALUE)
                ans = mins[i] - maxs[i-1];
        }
        
        return max;
    }
    
    
}