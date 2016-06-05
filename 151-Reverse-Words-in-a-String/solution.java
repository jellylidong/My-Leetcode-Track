public class Solution {
    public String reverseWords(String s) {
        String[] ss = s.trim().split("\\s+"); // regx of >= 1 spaces
        StringBuilder sb = new StringBuilder();
        if(ss.length > 0){
            for(int i = ss.length-1; i > 0; i--)
                sb.append(ss[i] + " ");
            sb.append(ss[0]);
        }
        
        return sb.toString();
    }
    
    
}