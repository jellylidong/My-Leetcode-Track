public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        // HashSet<Integer> ans = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
    
        for(int i = 0; i < input.length(); i++){
            char op = '+';
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                op = c;
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for(int n1: left){
                    for(int n2: right){
                        switch (op){
                            case '+':
                                ans.add(n1 + n2);
                                break;
                            case '-':
                                ans.add(n1 - n2);
                                break;
                            case '*':
                                ans.add(n1 * n2);
                                break;
                        }
                    }
                }
            }
        }
        if(ans.size() == 0)
            ans.add(Integer.parseInt(input));
        // return new ArrayList<Integer>(ans);
        return ans;
    }
}