public class Solution {
    String[] table = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                           "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tenTable = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int n) {
        String res = "";
        
        int B = n/1000000000;
        n = n - B*1000000000;
        int M = n/1000000;
        n = n - M*1000000;
        int T = n/1000;
        n = n - T*1000;
        
        if(B != 0)
            res += format(B) + " " + "Billion ";
        if(M != 0)
            res += format(M) + " " + "Million "; 
        if(T != 0)
            res += format(T) + " " + "Thousand ";
        if(n != 0)
            res += format(n);
            
        if(res.length() == 0)
            return "Zero";
        else
            return res.trim();
    }
    
    String format(int n){//used to format number < 1000
        String res = "";
        
        int h = n/100;
        n = n - h*100;
        int t = n/10;
        n = n - t*10;
        
        if(h != 0)
            res += table[h] + " " + "Hundred ";
        if(t == 1)
            res += table[t*10+n];
        else if(t > 1){
            res += tenTable[t];
            if(n != 0)
                res += " " + table[n];
        }
        if(t == 0)
            res += table[n];
        
        
        
        
        return res.trim();
    }
}