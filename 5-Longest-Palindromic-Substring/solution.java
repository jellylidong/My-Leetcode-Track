public class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String ans = "";
        
        int lo = 0;
        int hi = 0;
        
        for(int i = 0; i < s.length(); i++){
            int n1 = search(s.substring(0, i), s.substring(i+1)) + 1;
            int n2 = search(s.substring(0, i+1), s.substring(i+1));
            if(n1 > n2 && n1 > max){
                max = n1;
                int half = (n1-1)/2;
                // ans = s.substring(i-half, i) + s.charAt(i) + s.substring(i+1, i+1+half);
                lo = i-half;
                hi = i+1+half;
            }
            if(n2 > n1 && n2 > max){
                max = n2;
                int half = n2/2;
                // ans = s.substring(i+1-half, i+1) + s.substring(i+1, i+1+half);
                lo = i+1-half;
                hi = i+1+half;
            }
        }
        
        return s.substring(lo, hi);
    }
    
    public int search(String s1, String s2){
        int i1 = s1.length()-1;
        int i2 = 0;
    
        int count = 0;
        while(i1 >= 0 && i2 < s2.length()){
            if(s1.charAt(i1) == s2.charAt(i2)){
                count += 2;
                i1--;
                i2++;
            }
            else
                break;
        }
        
        return count;
    }
}