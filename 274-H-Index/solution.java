public class Solution {
    public int hIndex(int[] c) {
        // Arrays.sort(c);
        // int len = c.length;
        // for(int i = 0; i < len; i++){
        //     if(c[i] >= len-i)
        //         return len - i;
        // }
        
        // return 0;
        
        //above code works O(nlgn)
        //a better method is O(n)
        //assume the length of c is L,
        //so the h index can be at most L according to the defination h parpers has >= h citation
        //there cause there are L papers
        
        int L = c.length;
        if(L == 0)
            return 0;
            
        int[] count = new int[L+1];
        for(int i = 0; i < L; i++){
            if(c[i] >= L) // paper with >=L citations must be part of h-index papers
                count[L]++;
            else
                count[c[i]]++; //c[i] < L
        }
        
        int sum = 0; //sum is the amount of papers with (>= h citations)
        for(int h = L; h >= 0; h--){
            sum += count[h];
            if(sum >= h)
                return h;
        }
        
        return 0;
    }
}