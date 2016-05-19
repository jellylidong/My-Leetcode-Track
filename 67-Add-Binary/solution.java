public class Solution {
    public String addBinary(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();
        char[] n1; //short
        char[] n2; //long
        if(l1 < l2){
            n1 = a.toCharArray();
            n2 = b.toCharArray();
        }
        else{
            n1 = b.toCharArray();
            n2 = a.toCharArray();
        }
        for(int i = n1.length-1; i >= 0; i--){
            int c = n1[i] - '0';
            for(int j = n2.length-1 - (n1.length-1-i); j >= 0; j--){
                int cur = n2[j] - '0';
                if(c + cur == 2){
                    c = 1;
                    n2[j] = '0';
                }
                else{
                    n2[j] = (c + cur == 1)? '1':'0';
                    c = 0;
                    break;
                }
            }
            if(c == 1){
                String tmp = "1" + new String(n2);
                n2 = tmp.toCharArray();
            }
            // System.out.println(new String(n2));
        }
        
        return new String(n2);
    }
}