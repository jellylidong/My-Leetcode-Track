/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] smallBuf = new char[4];
        int ans = 0;
        int count = Integer.MAX_VALUE;
        while(count >= 4 && ans < n){
            count = read4(smallBuf);
            for(int i = 0; i < count; i++){
                buf[ans] = smallBuf[i];
                ans++;
                if(ans == n)
                    return ans;
            }
           
        }
        return ans;
        
    }
}