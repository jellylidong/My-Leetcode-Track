public class Solution {
    public String convert(String s, int n) {
        if(n <= 1)
            return s;
        String[] ss = new String[n];
        for(int i = 0; i < n; i++)
            ss[i] = "";
        
        for(int i = 0; i < s.length(); i++){
            int id = i%(n+n-2);
            if(id >= n){
                id = n+n-2-id;
            }
            ss[id] += s.charAt(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for(String str: ss)
            sb.append(str);
            
        return sb.toString();
    }
}