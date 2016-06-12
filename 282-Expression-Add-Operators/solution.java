public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        if(num.length() == 0)
            return ans;
        
        helper(num, 0, num.length()-1, "", 0, 0, target, ans);
        
        return ans;
    }
    
    public void helper(String s, int lo, int hi, String curStr, long curVal, long preNum, int target, List<String> ans){
        // if(curStr.length() == 2*s.length()-1 && curVal == target)
        
        if(lo == s.length() && curVal == target)
            ans.add(curStr);
        else{
            for(int i = lo; i <= hi; i++){
                if(i != lo && s.charAt(lo) == '0')
                    break;
                    
                String newStr = s.substring(lo, i+1);
                long newVal = Long.parseLong(newStr);
                // if(curStr.length() == 0){
                if(curStr.length() == 0){
                    helper(s, i+1, hi,  newStr, newVal, newVal, target, ans);
                }
                else{
                    helper(s, i+1, hi, curStr+"+"+newStr, curVal+newVal, newVal, target, ans);
                    helper(s, i+1, hi, curStr+"-"+newStr, curVal-newVal, -newVal, target, ans);
                    helper(s, i+1, hi, curStr+"*"+newStr, curVal-preNum + preNum*newVal, preNum*newVal, target, ans);
                }
            }
        }
    }
    
    
    
}