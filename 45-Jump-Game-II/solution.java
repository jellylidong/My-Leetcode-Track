//!!!!!!!!!!!1
//understand in BFS way
//each step is a bfs level

public class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2)
            return 0;
        
        int curMax = 0;
        int nextMax = 0;
        int step = 0;
        
        int i = 0; // current position
        while(nums.length-i+1 > 0){
            step++;
            for(; i <= curMax; i++){
                nextMax = Math.max(nextMax, nums[i]+i);
                if(nextMax >= nums.length-1)
                    return step;
            }
            curMax = nextMax;
        }
        
        return -1;
    }
    
    // [7,0,9,6,9,6,1,7,9,0,1,2,9,0,3]
}