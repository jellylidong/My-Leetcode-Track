public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        int ans = 0;
        int mask = 1;
        
        for(int i = 0; i < 32; i++){
            if((n & mask) != 0)
                ans++;
            mask = mask << 1;
        }
        
        return ans;
    }
}

/*note: for int, 32 bits, its range is
  -2147483648 to 2147483647
  2147483647's binary form is 31 1s
  
  note taht only 31 bits are used, the 32th bit is sign bit
  
  int ans = 0;
        
        while(n != 0){
            if(n%2 == 1)
                ans++;
            n = n/2;
        }
        
        return ans;

  that's why above code doesn't work for number   2147483648 (10000000000000000000000000000000),
  because its 32th bit is 1, but bit 30 to 0 is 0, devison won't use sign bit to compute
  
  ??? why using n >> 1 doesn't work?
*/