public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        int scalar = 1;
        while(m !=0 || n != 0){
            if(m == n)
                res = scalar*(m%2) + res;
            
            m /= 2;
            n /= 2;
            scalar *= 2;
        }
        
        return res;
        
    }
}