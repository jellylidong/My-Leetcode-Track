public class Solution {
    public int maxProduct(String[] words) {
        int ans = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                if(!hasSharedChar(words[i], words[j])){
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        
        return ans;
    }
    
    public boolean hasSharedChar(String s1, String s2){
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s1.length(); i++){
            set.add(s1.charAt(i));
        }
        for(int i = 0; i < s2.length(); i++){
            if(set.contains(s2.charAt(i)))
                return true;
        }
        
        return false;
            
    }
}