public class Solution {
    public boolean canWin(String s) {
        if(s.length() <= 1)
            return false;
        
        boolean res = false;
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+'){
                // boolean left = canWin(s.substring(0, i));
                // boolean right = canWin(s.substring(i+2));
                res = res || !canWin(s.substring(0,i) + "--" + s.substring(i+1));
            }
            if(res)
                break;
        }
        
        return res;
    }
    
    // public boolean canWin(String s, int who){
    //     if(s.length() <= 1)
    //         return true;
        
    //     boolean res = false;
    //     for(int i = 0; i < s.length()-1; i++){
    //         if(s.charAt(i) == '+' && s.charAt(i+1) == '+')
    //             res ||= !canWin(s.substring(0, i), (who+1)%2) || !canWin(s.substring(i+2), (who+1)%2);
    //     }
        
    //     return who==0
    // }
}