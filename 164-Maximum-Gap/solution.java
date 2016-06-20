public class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2)
            return 0;
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int n: nums){
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        
        int size = (int)Math.ceil((double)(max-min)/(nums.length-1));
        // 1.2->2, 1.0->1, 1.5->2
        // System.out.println(size);
        int[] maxs = new int[nums.length-1];
        int[] mins = new int[nums.length-1];
        Arrays.fill(maxs, Integer.MIN_VALUE);
        Arrays.fill(mins, Integer.MAX_VALUE);
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == max || nums[i] == min)
                continue;
            int id = (nums[i]-min)/size;
            maxs[id] = Math.max(maxs[id], nums[i]);
            mins[id] = Math.min(mins[id], nums[i]);
        }
        // for(int i = 0; i < nums.length-1; i++){
        //     // System.out.println(maxs[i] + " " + mins[i]);    
        // }
        
        int ans = 0;
        int preMin = min;
        for(int i = 0; i < nums.length-1; i++){
            if(mins[i] != Integer.MAX_VALUE){
                ans = Math.max(mins[i]-preMin, ans);
                // ans = Math.max(maxs[i]-mins[i], ans);
                preMin = maxs[i];
            }
        }
        // System.out.println(max + " " + preMin);
        ans = Math.max(ans, max-preMin);
        return ans;
    }
    
    
}