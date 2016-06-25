public class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<String>();
        String[] ss = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        ans.add("");
        for(int i = 0; i < digits.length(); i++){
            String cur = ss[digits.charAt(i) - '0'];
            List<String> newAns = new ArrayList<>();
            for(int j = 0; j < cur.length(); j++){
                for(String s: ans){
                    newAns.add(s + cur.charAt(j));
                }
            }
            ans = newAns;
        }
        return ans;
    }
}