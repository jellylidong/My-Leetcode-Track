public class Solution {
    public String shortestPalindrome(String s) {
        if(s.length() == 0)
            return "";
        String rev = new StringBuilder(s).reverse().toString();
        String ss = s + "#" + rev;
        // String ss = s + rev;
        int[] kmp = new int[ss.length()];
        int j = 0;
        for(int i = 1; i < ss.length(); i++){
            if(ss.charAt(i) == ss.charAt(j)){
                j++;
                kmp[i] = kmp[i-1] + 1;
            }
            else{
                while(j != 0 && ss.charAt(i) != ss.charAt(j)){
                    j = kmp[j-1];
                }
                if(ss.charAt(i) == ss.charAt(j)){
                    kmp[i] = j + 1;
                    j++;
                }
            }
            
        }
        
        // System.out.println(rev.length() - kmp[kmp.length-1]);
        return rev.substring(0, rev.length() - kmp[kmp.length-1]) + s;
    }
    
    // "aacecaaa"
    // "aaa"
}