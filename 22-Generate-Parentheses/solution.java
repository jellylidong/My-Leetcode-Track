public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans = new ArrayList<>();
        helper(n, n, "", ans);
        return ans;
    }
    
    public void helper(int left, int right, String cur, List<String>ans){
        if(left == 0 && right == 0)
            ans.add(cur);
        else{
            if(cur.length() == 0)
                helper(left-1, right, "(", ans);
            else{
                if(left - 1 >= 0 && right >= left-1)
                    helper(left-1, right, cur+"(", ans);
                if(right - 1 >= 0 && right-1 >= left)
                    helper(left, right-1, cur+")", ans);
            }
        }
    }
}