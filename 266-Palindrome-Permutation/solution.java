public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[27];
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            count[c-'a']++;
        }
        
        int odd = 0;
        for(int i = 0 ; i < 27; i++){
            if(count[i]%2 == 1)
                odd++;
        }
        
        return odd > 1;
    }
}