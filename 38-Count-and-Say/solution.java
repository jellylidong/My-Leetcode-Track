public class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        if(n == 1)
            return ans;
            
        for(int i = 2; i <= n; i++){ //i is the length of next ans
            // System.out.println(ans);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < ans.length();){ //j-1 is the position of current ans
                int count = 1;
                char c = ans.charAt(j);
                while(j+1 < ans.length() && ans.charAt(j+1) == c){
                    j++;
                    count++;
                }
                sb.append(count);
                sb.append(c);
                j++;
            }
            ans = sb.toString();
        }
        
        return ans;
    }
}