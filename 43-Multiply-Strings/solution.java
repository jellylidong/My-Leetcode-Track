public class Solution {
    // public String multiply(String num1, String num2) {
        
    //     //corner cases: one of the number is 0
        
    //     String ans = "0";
    //     for(int i = num2.length()-1; i >= 0; i--){
    //         char c = num2.charAt(i);
    //         if(c == '0')
    //             continue;
    //         ans = add(mult(num1, c, num2.length()-1-i), ans);
    //     }
        
    //     int i = 0;
    //     while(i < ans.length()-1 && ans.charAt(i) == '0')
    //         i++;
    //     return ans.substring(i);
    // }
    
    // public String mult(String s1, char s2, int zeros){
    //     String ans = "";
        
    //     int carry = 0;
        
    //     for(int i = s1.length()-1; i >= 0; i--){
    //         int n1 = s1.charAt(i) - '0';
    //         int n2 = s2 - '0';
    //         int n = n1*n2 + carry;
    //         ans = n%10 + ans;
    //         carry = n/10;
    //     }
    //     if(carry != 0)
    //         ans = carry + ans;
    //     for(int i = 0; i < zeros; i++)
    //         ans += 0;
    //     return ans;
    // }
    
    // public String add(String s1, String s2){
    //     int i1 = s1.length()-1;
    //     int i2 = s2.length()-1;
        
    //     String ans = "";
    //     int carry = 0;
        
    //     while(i1 >= 0 && i2 >= 0){
    //         int n1 = s1.charAt(i1) - '0';
    //         int n2 = s2.charAt(i2) - '0';
    //         int sum = n1 + n2 + carry;
            
    //         ans = (sum%10) + ans;
    //         carry = sum/10;
    //         i1--;
    //         i2--;
    //     }
    //     while(i1 >= 0){
    //         int n1 = s1.charAt(i1) - '0';
    //         int sum = n1 + carry;
            
    //         ans = (sum%10) + ans;
    //         carry = sum/10;
    //         i1--;
    //     }
    //     while(i2 >= 0){
    //         int n2 = s2.charAt(i2) - '0';
    //         int sum = n2 + carry;
            
    //         ans = (sum%10) + ans;
    //         carry = sum/10;
    //         i2--;
    //     }
    //     if(carry != 0)
    //         ans = carry + ans;
    //     return ans;
    // }
    
    
    //the above code works fine but kind of slow,
    //faster method:
    //len1 = m, len2 = n, then the mult(s1, s2)'length is at most m+n
    //c1 = s1.charAt(i), c2 = s2.cahrAt(j)
    //then c1*c2 result part of the res[i+j] and res[i+j+1]
    
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m+n];
        
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                int mult = n1*n2;
                
                //noet here !!!!!!!!!!!!!!!!!
                int sum = mult + res[i+j+1];
                
                res[i+j] += sum/10;
                res[i+j+1] = sum%10;
            }
        }
        
        int i = 0;
        while(i < res.length-1 && res[i] == 0)
            i++;
            
        StringBuilder sb = new StringBuilder();
        for(int j = i; j < res.length; j++)
            sb.append(res[j]);
            
        return sb.toString();
        
    }
}