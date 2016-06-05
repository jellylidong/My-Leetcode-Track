public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int count = 0;
        
        char[] cs = new char[27];
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(cs[c-'a'] == 0){
                count++;
                cs[c-'a'] = 1;
                ans = Math.max(ans, count);
            }
            else{
                for(int j = i-count; j < i && s.charAt(j) != c; j++){
                    cs[s.charAt(j)-'a']--;
                    count--;
                }
            }
        }
        
        return ans;
    }
}