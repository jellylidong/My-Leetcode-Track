public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        int[] count = new int[27];
        
        for(int i = 0 ; i < s.length(); i++){
            char cs = s.charAt(i);
            char ts = t.charAt(i);
            count[cs-'a']++;
            count[ts-'a']--;
        }
        
        for(int i = 0; i < 27; i++){
            if(count[i] < 0)
                return false;
        }
        
        return true;
    }
}