/*instead of using hashset to record the chars that a string has
here use bit manipulation
ie for words[i], for a char in it, mask[i] |= 1 << (words[i].charAt(j)-'a')
then we can judge if two strings share chars by mask[i] & mask[j] == 0
*/

public class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] mask = new int[len];
        
        for(int i = 0; i < len; i++){
            for(char c: words[i].toCharArray()){
                mask[i] |= 1 << (c-'a');
            }
        }
        
        int ans = 0;
        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++){
                if((mask[i] & mask[j]) == 0) //bit calculation has lower priority than logic calculation, bracket it
                    ans = Math.max(ans, words[i].length() * words[j].length());
            }
        }
        
        return ans;
    }
    
    
}