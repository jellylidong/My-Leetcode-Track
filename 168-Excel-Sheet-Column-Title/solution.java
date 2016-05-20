public class Solution {
    public String convertToTitle(int n) {
        String ans = "";
        while(n != 0){
            int cur = n%26;
            if(cur == 0){
                ans = 'Z' + ans;
                n = n/26 - 1;
            }
            else{
                ans =(char)('A'-1+cur) + ans;
                n = n/26;
            }
                
            
        }
        
        return ans;
    }
}

//26, 567, 52