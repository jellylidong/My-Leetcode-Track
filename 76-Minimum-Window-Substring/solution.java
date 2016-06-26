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
        int count = 0; // count means how many chars in t current s.substirng covers
        int minLo = 0;
        // int minHi = 0;
        int minLen = Integer.MAX_VALUE;
        
        for(; hi < s.length(); hi++){
            char c = s.charAt(hi);
            if(sMap.containsKey(c)){
                sMap.put(c, sMap.get(c)+1);
                
                //after we add 1, sMap.get(c) still <= tMap.get(c)
                //it means the add is valid
                if(sMap.get(c) <= tMap.get(c))
                    count++;
            }
            
            //all chars in t are covered now
            if(count == t.length()){
                
                //clear redundant begginning chars
                //1. chars that are not in t
                //2. chars are in t but there are too many in current s.substring
                while(!sMap.containsKey(s.charAt(lo)) || sMap.get(s.charAt(lo)) > tMap.get(s.charAt(lo))){
                    if(sMap.containsKey(s.charAt(lo)))
                        sMap.put(s.charAt(lo), sMap.get(s.charAt(lo))-1);
                    lo++;
                }
                
                if(hi-lo+1 < minLen){
                    minLo = lo;
                    // minHi = hi;
                    minLen = hi-lo+1;
                }
                
                //after update the minLen and minLo, we need to start from next position, ie lo+1
                sMap.put(s.charAt(lo), sMap.get(s.charAt(lo))-1);
                count--;
                lo++;
            }
        }
        
        return minLen == Integer.MAX_VALUE? "" :s.substring(minLo, minLo+minLen);
    }
    
    //"caae" "cae"

}