public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0)
            return 0;
        
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        int start = -1;
        int len = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // System.out.println(c + " " + i);
            map.put(c, i);
            if(map.size() > k){
                char c2 = s.charAt(start+1);
                int start2 = map.get(c2);
                for(int j = start+1; j <= start2; j++){
                    map.remove(s.charAt(j));
                }
                start = start2;
            }
            
            len = i - start;
            max= Math.max(len, max);
        }
        return max;
    }
}