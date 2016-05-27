public class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        generateParenthesis(n, n, "");
        return ans;
    }
    
    //left and right are the number of left and right bracket
    public void generateParenthesis(int left, int right, String cur){
        if(left == 0 && right == 0){
            ans.add(cur);
            return;   
        }
        if(cur.length() == 0)
            generateParenthesis(left-1, right, "(");
        else{
            //if we want to put a "(" next, 
            //we must guarantee that the left backet number >= 1 and right bracket number >= left-1
            if(left-1 >= 0 && right >= left-1)
                generateParenthesis(left-1, right, cur+"(");
                
            //if we want to put a ")" next,
            //we must guarantee that right bracket number >= 1 and right-1 >= left
            if(right-1 >= 0 && right-1 >= left)
                generateParenthesis(left, right-1, cur+")");
        }
    }
}