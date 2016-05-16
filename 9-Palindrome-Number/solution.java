public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
            
        if(x == 0)
            return true;
        int len = 0;
        int tmp = x;
        while(tmp != 0){
            len++;
            tmp /= 10;;
        }
        while(len > 0 && x > 0){
            int lo = x%10;
            int hi = x/((int)Math.pow(10, len-1));
            if(hi != lo){
                System.out.print(x);
                return false;
            }
            x -= lo;
            x -= hi*(int)Math.pow(10, len-1);
            x /= 10;
            len -= 2;
        }
        
        return true;
    }
    
    // public boolean isPalindrome(int x) {
    
        
    // }
}