public class Solution {
    public String reverseWords(String str) {
       // = s.trim();
       String[] ss = str.split("\\s+");
       
       StringBuilder sb = new StringBuilder();
       for(int i = ss.length-1; i >= 0; i--){
          sb.append(ss[i]);
          sb.append(" ");
       }
       
       return sb.toString().trim();
        
    }
}