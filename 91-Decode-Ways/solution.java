public class Solution {
    int ans;
    public int numDecodings(String s) {
        ans = 0;
        if(s.length() == 0)
            return ans;
        search(0, s);
        
        return ans;
    }
    
    public void search(int i , String s){
        if(i == s.length()){
            ans++;
            return;
        }
        search(i+1, s);
        if(i+2 <= s.length()){
            int n = Integer.parseInt(s.substring(i, i+2));
            if(n <= 26)
                search(i+2, s);
        }
    }
}