public class Solution {
    public int findDuplicate(int[] nums) {
        int lo = 1;
        int hi = nums.length-1; // len is n+1, contains number 1..n (both inclusive)
        
        while(lo < hi){
            int m = lo + (hi-lo)/2;
            int count = 0;
            for(int n: nums){
                if(n <= m)
                    count++;
            }
            if(count <= m)
                lo = m+1;
            else
                hi = m;
        }
        
        return lo;
    }
    
    // [1,1,2]
    // [2,2,2,2,2]
    // [1,3,4,2,1]
}