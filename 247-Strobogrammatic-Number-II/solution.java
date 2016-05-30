public class Solution {
    
    //hard poin of this problem is we need to handle results with two-end 0, ie 010, 0690 etc
    
    String[] left =  {"0","1","6","8","9"};
    String[] right = {"0","1","9","8","6"};
    int maxLen = 0;
    public List<String> findStrobogrammatic(int n) {
        maxLen = Math.max(maxLen, n);
        List<String> ans = new ArrayList<>();
        if(n == 1){
            for(int i = 0; i < 5; i++){
                if(i == 2 || i == 4) //note: single  6 and 9 can not be Strobogrammatic Number
                    continue;
                ans.add(left[i]);
            }
            return ans;
        }
        if(n == 2){
            for(int i = 0; i < 5; i++){
                if(i == 0 && n == maxLen)
                    continue;
                ans.add(left[i]+right[i]);
            }
            
            return ans;
        }
        
        List<String> subAns = findStrobogrammatic(n-2);
        for(String str: subAns){
            for(int i = 0; i < 5; i++){
                if(i == 0 && n == maxLen)
                    continue;
                ans.add(left[i] + str + right[i]);
            }
        }
        
        return ans;
    }
    
    
}