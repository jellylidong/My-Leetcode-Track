public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] count = new int[26];
        for(int i = 0; i < t.length(); i++){
            count[t.charAt(i)-'a']++;
            count[s.charAt(i)-'a']--;
        }
        for(int n: count){
            if(n != 0)
                return false;
        }
        return true;
    }
}