public class Solution {
    public int lengthOfLastWord(String s) {
        String[] ss = s.split(" ");
        int len = ss.length;
        if(len == 0)
            return 0;
        return ss[len-1].length();
    }
}