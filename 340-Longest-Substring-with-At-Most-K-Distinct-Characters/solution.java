public class Solution {
    
    //this problem is easy to think but when operating, 
    //there are many small tips that can make the code run to null pointer exceptions
    
    //the basic iead is we use a hash map to keep the char and its index
    //if the map size > k, we need to remove the first removable char from the left of current Longest Substring with At Most K Distinct Characters 
    
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0)
            return 0;
        
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        int start = -1;
        int len = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            map.put(c, i);
     
            if(map.size() > k){
                char c2 = s.charAt(start+1); // the first char of current Longest Substring with k+1 Distinct Characters 
     
                int start2 = map.get(c2); // the right most position of this char 
                //this means we only need to remove one of the char between start+1 and start2, 
                //(note start start from 0, ie start is the previous one positon of the current substring)
                //then we can keep the hash map size to k
                
                int j = start+1;
                for(; j <= start2 && map.size() > k; j++){
                    //this judge is very important
                    if(j == map.get(s.charAt(j)))
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