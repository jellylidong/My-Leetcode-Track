public class Solution {
    public List<String> generateAbbreviations(String word) {
       List<String> ans = new ArrayList<>();
       gen(ans, word, 0, "", 0);
       return ans;
    }
    
    public void gen(List<String> list, String word, int pos, String cur, int count){
        if(pos == word.length()){
            if(count > 0)
                cur += count;
            list.add(cur);
        }
        else{
            gen(list, word, pos+1, cur, count+1); // noe keep current char, ie abbreviate as part of the count
            gen(list, word, pos+1, cur+(count > 0? count: "")+word.charAt(pos), 0); //keep current char as part of the final string
        }
        
    }
}