public class Solution {
    public int maxProduct(String[] words) {
        int ans = 0;
        for(int i = 0; i < words.length; i++){
            HashSet<Character> set = new HashSet<>();
            for(int k = 0; k < words[i].length(); k++){
                set.add(words[i].charAt(k));
            }
            for(int j = i+1; j < words.length; j++){
                if(!hasSharedChar(set, words[j])){
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        
        return ans;
    }
    
    public boolean hasSharedChar(HashSet<Character> set, String s2){
        
        for(int i = 0; i < s2.length(); i++){
            if(set.contains(s2.charAt(i)))
                return true;
        }
        
        return false;
            
    }
}