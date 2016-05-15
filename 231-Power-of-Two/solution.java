public class Solution {
    public boolean isPowerOfTwo(int n) {
        // while(n%2 == 0 && n != 0)
        //     n /= 2;
            
        // return n == 1;
        
        return 1073741824%n == 0;
    }
}