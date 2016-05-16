public class Solution {
    // public boolean isPalindrome(int x) {
    //     if(x < 0)
    //         return false;
            
    //     if(x == 0)
    //         return true;
    //     int len = 0;
    //     int tmp = x;
    //     while(tmp != 0){
    //         len++;
    //         tmp /= 10;;//use / instead of * to avoid overflow
    //     }
    //     while(len > 0 && x > 0){
    //         int lo = x%10;
    //         int hi = x/((int)Math.pow(10, len-1));
    //         if(hi != lo){
    //             // System.out.print(x);
    //             return false;
    //         }
    //         x -= lo;
    //         x -= hi*(int)Math.pow(10, len-1);
    //         x /= 10;
    //         len -= 2;
    //     }
        
    //     return true;
    // }
    
    public boolean isPalindrome(int x) {
    
        int p = x;
        int q = 0;
        while(p > 0){
            q = q*10;
            q += p%10;
            p /= 10;
        }
        return q == x;
    }
}