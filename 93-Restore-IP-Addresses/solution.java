public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        build(s, 0, ans, "");
        return ans;
    }
    
    public void build(String s, int alreadyHas, List<String> ans, String curAns){
        
        
        
        if(alreadyHas == 4 && s.length() == 0){
            ans.add(curAns);
            return;
        }
        
        for(int i = 1; i <= 3 && i <= s.length(); i++){
            // //number start with 0 is invalid
            if(s.charAt(0) == '0' && i > 1)
                break;
            
            String sub = s.substring(0, i);
            String sub2 = s.substring(i);
            if(Integer.parseInt(sub) <= 255 && sub2.length() <= 3*(4-alreadyHas-1) && sub2.length() >= (4-alreadyHas-1)){
                if(alreadyHas == 0)
                    build(s.substring(i), alreadyHas+1, ans, curAns+sub);
                    
                else
                    build(s.substring(i), alreadyHas+1, ans, curAns+"."+sub);
                
                
            }
        }
    }
}