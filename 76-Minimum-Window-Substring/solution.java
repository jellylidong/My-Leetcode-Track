public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(tMap.containsKey(c))
                tMap.put(c, tMap.get(c)+1);
            else
                tMap.put(c, 1);
        }
        
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int lo = 0;
        int minStart = 0;
        for(int hi = 0; hi < s.length(); hi++){
            char c = s.charAt(hi);
            if(tMap.containsKey(c)){
                sMap.put(c, sMap.containsKey(c)? sMap.get(c)+1: 1);
                if(sMap.get(c) <= tMap.get(c)){
                    count++;//a valid put, count++
                }
            }
            if(count == t.length()){
                //update lo
                //count == t.length() means all chars in t are covered
                //but current length can have redundant chars
                while(!tMap.containsKey(s.charAt(lo)) || sMap.get(s.charAt(lo)) > tMap.get(s.charAt(lo))){
                    if(tMap.containsKey(s.charAt(lo))){
                        sMap.put(s.charAt(lo), sMap.get(s.charAt(lo))-1);
                    }
                    lo++;
                }
                //update minLen and minStart
                if(hi-lo+1 < minLen){
                    minLen = hi-lo+1;
                    minStart = lo; // we must keep the minStart of minLen, it will be used to return result
                }
                
                //after above steps, str start from lo (inclusive) is a valid string covers t
                //we need to start next loop from lo+1
                sMap.put(s.charAt(lo), sMap.get(s.charAt(lo))-1);
                lo++;
                count--;
            }
            
        }
        
        if(minLen == Integer.MAX_VALUE)
            return "";
        return s.substring(minStart, minStart+minLen);
    }
}