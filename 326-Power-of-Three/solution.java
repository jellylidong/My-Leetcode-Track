public class Solution {
    public boolean isPowerOfThree(int n) {
        while(n%3 == 0 && n != 0)
            n /= 3;
            
        return n == 1;
    }
}

//star reason: follow up failed
//solution
//return ( n>0 &&  1162261467%n==0);
//1162261467 is the largest power3 integer