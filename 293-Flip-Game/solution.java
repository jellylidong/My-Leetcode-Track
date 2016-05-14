public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<>();
        if(s.length() <= 1 )
            return ans;
            
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+')
                ans.add(s.substring(0, i) + "--" + s.substring(i+2));
                
            // if(s.charAt(i) == '-' && s.charAt(i+1) == '-')
            //     ans.add(s.substring(0, i) + "++" + s.substring(i+2));
        }
        
        return ans;

    }
}