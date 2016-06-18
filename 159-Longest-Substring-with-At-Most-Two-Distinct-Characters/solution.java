public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        int lo = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int hi = 0; hi < s.length(); hi++){
            char c = s.charAt(hi);
            map.put(c, hi);
            while(map.size() > 2){
                if(map.get(s.charAt(lo)) == lo)
                    map.remove(s.charAt(lo));
                lo++;
            }
            // System.out.println(lo +" " + hi);
            max = Math.max(max, hi-lo+1);
        }
        
        return max;
    }
}