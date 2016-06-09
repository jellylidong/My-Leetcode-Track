public class Solution {
    // public int longestValidParentheses(String s) {
    //     int max = 0;
    //     char[] cs = s.toCharArray();
    //     Stack<Integer> stk = new Stack<>();
    //     for(int i = 0; i < s.length(); i++){
    //         char c = cs[i];
    //         if(c == '(')
    //             stk.push(i);
    //         else if(c == ')'){
    //             if(stk.isEmpty() || s.charAt(stk.peek()) == ')'){
    //                 // max = Math.min(max, i);
    //                 stk.push(i);
    //             }
    //             else if(s.charAt(stk.peek()) == '('){
    //                 stk.pop();
    //                 if(stk.isEmpty())
    //                     max = Math.max(max, i);
    //                 else
    //                     max = Math.max(max, i-stk.peek());
    //             }
    //         }
    //     }
        
    //     return max;
    // }
    
    
    //above code get TLE for case "((((.....((((" (all chars are "(" and very long)
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()]; 
        int max = 0;
        char[] cs = s.toCharArray();
        for(int i = 1; i < s.length(); i++){
            char c = cs[i];
            // if(c == '(')
            //     continue;
            if(c == ')'){
                if(s.charAt(i-1) == '(')
                    dp[i] = i-2 >= 0? dp[i-2] + 2: 2;
                if(s.charAt(i-1) == ')' ){
                    // if(i-1-dp[i-1]-1 >= 0)
                    //     dp[i] = dp[i-1-dp[i-1]-1] + dp[i-1] + 2;
                    // else if(i-1-dp[i-1] == 0 && cs[0] == '(')
                    //     dp[i] = dp[i-1] + 2;
                    
                    // // dp[i] = i-1-dp[i-1]-1 >= 0? dp[i-1-dp[i-1]-1] + dp[i-1] + 2: dp[i-1] + 2;
                    if(dp[i-1] == 0)
                        continue;
                    if(i-1-dp[i-1] >= 0 && cs[i-1-dp[i-1]] == '('){
                        if(i-1-dp[i-1]-1 >= 0)
                            dp[i] = dp[i-1-dp[i-1]-1] + 2 + dp[i-1];
                        else
                            dp[i] = 2 + dp[i-1];
                    }
                    
                }
            }
            
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
    // "(()())"
    // "()(())"
    // ")))))(((()("
    // "(()))())("
}