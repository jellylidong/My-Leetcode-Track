public class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        for(int i = s.length()-1; i >= 0; i--){
            int n1 = s.charAt(i)-'A'+1;
            int n2 = (int)Math.pow(26, s.length()-i-1);
            ans += n1*n2;
        }
        return ans;
    }
    
    
}