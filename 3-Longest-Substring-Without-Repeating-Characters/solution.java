public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int count = 0;
        
        HashSet<Character> cs = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(!cs.contains(c)){
                count++;
                cs.add(c);
                ans = Math.max(ans, count);
            }
            else{
                for(int j = i-count; j < i && s.charAt(j) != c; j++){
                    cs.remove(s.charAt(j));
                    count--;
                }
            }
        }
        
        return ans;
    }
}