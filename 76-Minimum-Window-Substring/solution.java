public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(tMap.containsKey(c))
                tMap.put(c, tMap.get(c)+1);
            else{
                tMap.put(c, 1);
                sMap.put(c, 0);
            }
        }
        
        int lo = 0;
        int hi = 0;
        int count = 0;
        int minLo = 0;
        int minHi = 0;
        int minLen = Integer.MAX_VALUE;
        
        for(; hi < s.length(); hi++){
            char c = s.charAt(hi);
            if(sMap.containsKey(c)){
                sMap.put(c, sMap.get(c)+1);
                count++;
            
                while(sMap.get(c) > tMap.get(c)){
                    char c2 = s.charAt(lo++);
                    if(sMap.containsKey(c2)){
                        sMap.put(c2, sMap.get(c2)-1);
                        count--;
                    }
                }
                while(!sMap.containsKey(s.charAt(lo)))
                    lo++;
            }
            if(count == t.length()){
                if(hi-lo+1 < minLen){
                    minLo = lo;
                    minHi = hi;
                    minLen = hi-lo+1;
                }
            }
        }
        
        return s.substring(minLo, minLo+minLen);
    }
}