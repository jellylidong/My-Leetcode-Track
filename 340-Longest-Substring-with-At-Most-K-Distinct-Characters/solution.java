public class Solution {
    
    //this problem is easy to think but when operating, 
    //there are many small tips that can make the code run to null pointer exceptions
    
    //the basic iead is we use a hash map to keep the char and its index
    //if the map size > k, we need to remove the first removable char from the left of current Longest Substring with At Most K Distinct Characters
    
    //these two cases give very good reason for these considerations
    // "ababffzzeee" 2
    // "abaccc" 2
    
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
                for(; j <= start2 && map.size() > k; j++){//once map size got ==k, we should stop remove
                    //this judge is very important
                    //for example we go through this string ab...bac...
                    //after we go though c, we got map size > k
                    //it's clear that we should remove b and the new sub string shuold start with ac...(start should = 2nd b's position)
                    //if we don't check j == map.get(s.charAt(j))
                    //we will remove 1st a, then the loop will stop
                    //we will get a new start value which is at 1st a's position, wrong !
                    if(j == map.get(s.charAt(j)))
                        map.remove(s.charAt(j));
                }
                start = j-1; 
                //why -1? let's see how this loop works
                //once remove executed, then j++, then check loop condition
                //since we define start as the privous one position of the longest substring, so start = j-1
            }
            // System.out.println(start);
            len = i - start;
            max= Math.max(len, max);
        }
        return max;
    }
    

}