public class Solution {
    public int trailingZeroes(int n) {
        // if(n == 0)
        //     return 1;
        int ans = 0;
        for(int i = 5; n/i >= 1; n = n/5){
            ans += n/i;
        }
        return ans;
    }
}

//http://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
//for 5! there is only one 5 => one 0
//for 11!, there are 5, 10 => 2 5s => two 0s
// ==> the tail 0s are the count of n/5 + n/25 + n/125...
//so we can let i = 5 then count += n/i, i*=5
//consider that i*=5 may exceed the max integer
//so use n/=5 instead