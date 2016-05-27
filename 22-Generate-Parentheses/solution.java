public class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        generateParenthesis(n, n, "");
        return ans;
    }
    
    public void generateParenthesis(int left, int right, String cur){
        if(left == 0 && right == 0){
            ans.add(cur);
            return;   
        }
        if(cur.length() == 0)
            generateParenthesis(left-1, right, "(");
        else{
            if(left-1 >= 0 && right > 0)
                generateParenthesis(left-1, right, cur+"(");
            if(right-1 >= 0 && right-1 >= left)
                generateParenthesis(left, right-1, cur+")");
        }
    }
}