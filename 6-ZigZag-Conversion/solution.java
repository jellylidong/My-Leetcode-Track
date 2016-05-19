public class Solution {
    public String convert(String s, int n) {
        if(n <= 1)
            return s;
        String[] ss = new String[n];
        for(int i = 0; i < n; i++)
            ss[i] = "";
        int id = 0;
        for(int i = 0; i < s.length(); i++){
            int di = n+n-2;
            if(di == 0)
                id = i;
            else
                id = i%di;
            if(id >= n){
                id = n - id;
            }
            ss[id] += s.charAt(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for(String str: ss)
            sb.append(str);
            
        return sb.toString();
    }
}