public class Solution {
    
    public String fractionToDecimal(int n, int d) {
        HashMap<Long, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        if(n == 0)
            return "0";
        if((n > 0 && d < 0) || (n < 0 && d > 0))
            sb.append("-");
        long nn = Math.abs((long)n);
        long dd = Math.abs((long)d);
        
        long num = nn/dd;
        sb.append(num);
        nn %= dd;
        if(nn != 0)
            sb.append(".");
        
        map.put(nn, sb.length());
        
        while(nn != 0){
            nn *= 10;
            num = nn/dd;
            nn %= dd;
            
            sb.append(num);
            if(map.containsKey(nn)){
                int p = map.get(nn);
                sb.insert(p, "(");
                sb.append(")");
                break;
            }
            else{
                map.put(nn, sb.length());
            }
        }
        
        return sb.toString();
    }
    
    
}