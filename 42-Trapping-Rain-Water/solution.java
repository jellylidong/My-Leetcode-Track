public class Solution {
    public int trap(int[] height) {
        int li = 0;
        int ri = height.length-1;
        
        int ans = 0;
        
        while(li+1 <= ri && height[li] <= height[li+1])
            li++;
        while(ri-1 >= li && height[ri] <= height[ri-1])
            ri--;
        
        while(li < ri){
            int left = height[li];
            int right = height[ri];
            
            if(left <= right){
                while(li < ri && height[li] <= left){
                    ans += left - height[li];
                    li++;
                }
            }
            else{//right <= left
                while(ri > li && height[ri] <= right){
                    ans += right - height[ri];
                    ri--;
                }
            }
        }
        
        return ans;
        
    }
}