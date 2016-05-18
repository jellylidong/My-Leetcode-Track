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
        while(ans < n){
            int count = read4(smallBuf);
            for(int i = 0; i < count; i++){
                buf[count] = smallBuf[i];
                ans++;
                if(ans == n || count < 4)
                    return ans;
            }
           
        }
        return ans;
        
    }
}