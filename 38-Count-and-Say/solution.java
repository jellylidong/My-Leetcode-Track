public class Solution {
    public String countAndSay(int n) {
        int i = 1;
        String str = "1";
        while(i < n){
            
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < str.length();){
                String num = str.substring(j, j+1);
                int count = 0;
                do{
                    j++;
                    count++;
                }while(j < str.length() && str.charAt(j) == str.charAt(j-1));
                sb.append(count);
                sb.append(num);
            }
            str = sb.toString();
            i++;
        }
        return str;
    }
}