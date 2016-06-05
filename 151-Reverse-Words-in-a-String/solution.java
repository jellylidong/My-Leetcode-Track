public class Solution {
    public String reverseWords(String s) {
        // String[] ss = s.split("\t\n\x0B\f\r+"); // regx of >= 1 spaces
        // StringBuilder sb = new StringBuilder();
        // if(ss.length > 0){
        //     for(int i = ss.length-1; i > 0; i--)
        //         sb.append(ss[i] + " ");
        //     sb.append(ss[0]);
        // }
        
        // return sb.toString();
        String[] parts = s.trim().split("\\s+");
String out = "";
for (int i = parts.length - 1; i > 0; i--) {
    out += parts[i] + " ";
}
return out + parts[0];
    }
    
    
}