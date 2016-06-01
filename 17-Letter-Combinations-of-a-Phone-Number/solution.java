public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] key = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0)
            return ans;
        ans.add("");
        
        for(int i = 0; i < digits.length(); i++){
            int cur = digits.charAt(i) - '0';
            String curStr = key[cur];
            List<String> newAns = new ArrayList<>();
            for(int j = 0; j < curStr.length(); j++){
                for(String s: ans){
                    newAns.add(s + curStr.charAt(j));
                }
            }
            ans = newAns;
        }
        
        return ans;
        
    }
}