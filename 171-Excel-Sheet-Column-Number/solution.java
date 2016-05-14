public class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        for(int i = 0; i < s.length() -1; i++){
            int n1 = 1 + (s.charAt(i) - 'A');
            int n2 = (int)Math.pow(26, s.length()-i-1);
            sum += n1*n2;
        }
        
        sum += s.charAt(s.length()-1) - 'A' + 1;
        
        return sum;
    }
}