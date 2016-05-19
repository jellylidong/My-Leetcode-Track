public class Solution {
    public int strStr(String haystack, String needle) {
        // if(haystack.length() == 0 && needle.length() == 0)
        //     return 0;
        if(haystack.length() < needle.length())
            return -1;
        if(haystack.equals(needle))
            return 0;
        
        for(int i = 0; i <= haystack.length()-needle.length(); i++){ //pay attention to the index, should be <=
            int cur = i;
            // System.out.println(haystack.substring(cur, cur+needle.length()));
            if(haystack.substring(cur, cur+needle.length()).equals(needle))
                return cur;
        }
        
        return -1;
    }
}

