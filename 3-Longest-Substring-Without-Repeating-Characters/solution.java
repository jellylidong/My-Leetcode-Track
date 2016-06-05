public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int count = 0;
        
        HashMap<Character, Integer> cs = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!cs.containsKey(c))
                cs.put(c, 0);
            if(cs.get(c)== 0){
                count++;
                cs.put(c, 1);
                ans = Math.max(ans, count);
            }
            else{
                for(int j = i-count; j < i && s.charAt(j) != c; j++){
                    cs.put(s.charAt(j), 0);
                    count--;
                }
            }
        }
        
        return ans;
    }
}