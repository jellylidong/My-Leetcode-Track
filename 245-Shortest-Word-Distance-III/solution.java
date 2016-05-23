public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int ans = Integer.MAX_VALUE;
        int i1 = -1;
        int i2 = -1;
        
        if(!word1.equals(word2)){
            for(int i = 0; i < words.length; i++){
                if(words[i].equals(word1))
                    i1 = i;
                if(words[i].equals(word2))
                    i2 = i;
                if(i1 != -1 && i2 != -1)
                    ans = Math.min(ans, Math.abs(i1-i2));
            }
        }
        else{
            int count = 0;
            for(int i = 0;  i < words.length; i++){
                if(words[i].equals(word1) && count%2 == 0){
                    i1 = i;
                    count++;
                }
                else if(words[i].equals(word2) && count%2 == 1){
                    i2 = i;
                    count++;
                }
                if(i1 != -1 && i2 != -1)
                    ans = Math.min(ans, Math.abs(i1-i2));
            }
        }
        
        return ans;

    }
}