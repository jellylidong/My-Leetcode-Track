public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int i = 0; i < nums.length; i++)
            diff ^= nums[i];
            //here diff is A^B, ie all bits that are diffrent in A and B    
            
            
        diff &= -diff; //here diff becomes the right most set bit
        //for binary number a = 0110, -1 = int(a)+1 = 1001+1=1010
        //actually we don't have to use the right most bit, we only need to use a bit that is only set in one of A and B
        //diff &= -diff is just a way fint one of them
        //here we assume the set bit position is I
        
        
        //the second loop we devide all numbers into 2 groups
        //one group with the bit I set, the other not
        //ie if diff&nums[i] == 0, it means the Ith bit of nums[i] is not set, vise versa
        //finally, since Ith bit is a bit is set in one of A and B
        //that means ans[0] and a[1] will only result in one of them
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++){
            if((diff & nums[i]) == 0)
                ans[0] ^= nums[i];
            else
                ans[1] ^= nums[i];
        }
        
        return ans;
    }
}