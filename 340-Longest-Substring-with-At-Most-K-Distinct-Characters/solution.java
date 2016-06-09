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
            // System.out.println(map.size());
            if(map.size() > k){
                char c2 = s.charAt(start+1);
                // System.out.println(c2);
                int start2 = map.get(c2);
                // System.out.println("start 2:" + start2);
                int j = start+1;
                for(; j <= start2 && map.size() > k; j++){
                    if(map.containsKey(s.charAt(j)) && j == map.get(s.charAt(j)))
                        map.remove(s.charAt(j));
                }
                start = j-1;
            }
            // System.out.println(start);
            len = i - start;
            max= Math.max(len, max);
        }
        return max;
    }
    
    // "ababffzzeee" 2
    // "abaccc" 2
}