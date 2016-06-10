public class Solution {
    //KMP solution
    //kmp[i] means current max length of substring end with s.charAt(i) (inclusive) that has appeared from the beginning of the string
    //for example string:
    // a  b  c  a  b  y
    // 0  0  0  1  2  0
    // the firt 1 means, at current position we have a string with max length 1, ie a, wihch is obviously is the beginning of this string
    //the first 2 means, at current position we have a string with max length 2, ie ab, which is the obviously the beginning pattern ab
    
    //as for how to build a kmp array, remember the code
    //if you forget watch this video  https://www.youtube.com/watch?v=GTJr8OvyEVQ
    
    //the idea is build a kmp array of the string s+"#"+reverse(s)
    //the kmp[len-1] means the max length the original string has in common with its reversed string from the beginning of the original string
    //it's kind of abstract, go through the following case can make you understand better
    //"abac"
    //"abac#caba" will give up kmp[kmp.len-1] = 3, which mean the rev has 3 chars in common with orignal s
    //once we know the max length of common string, then we can add res.substring(0, rev.len - maxLen) to original s
    
    //the "#" can be any other non alphabetic chars, it's used to force the count from the beginning of stirng
    // for case like "aaa", if don't add "#" the s+rev will be "aaaaaa", the kmp[len-1] is 5, rev.len-kmp[kmp.len-1] < 0
    //adding # can avoid this case
    
    //based this, XXXX actually we don't have use s + res(s), we can build a kmp for rev(s) by compare it with orignal s
    //the above idea is not feasible, the kmp of reverse(s) is based on s's kmp
    //so we can first build s's kmp, then build reverse(s)'s kmp based on s's kmp  
    
    
    // public String shortestPalindrome(String s) {
    //     if(s.length() == 0)
    //         return "";
    //     String rev = new StringBuilder(s).reverse().toString();
    //     String ss = s + "#" + rev;
    //     // String ss = s + rev;
    //     int[] kmp = new int[ss.length()];
    //     int j = 0;
    //     for(int i = 1; i < ss.length(); i++){
    //         if(ss.charAt(i) == ss.charAt(j)){
    //             j++;
    //             kmp[i] = kmp[i-1] + 1;
    //         }
    //         else{
    //             while(j != 0 && ss.charAt(i) != ss.charAt(j)){
    //                 j = kmp[j-1];
    //             }
    //             if(ss.charAt(i) == ss.charAt(j)){
    //                 kmp[i] = j + 1;
    //                 j++;
    //             }
    //         }
            
    //     }
        
    //     // System.out.println(rev.length() - kmp[kmp.length-1]);
    //     return rev.substring(0, rev.length() - kmp[kmp.length-1]) + s;
    // }
    
    //this method build two kmps, but not very concise, I think the above method is better
    public String shortestPalindrome(String s) {
        if(s.length() == 0)
            return "";
        int[] kmp_s = new int[s.length()];
        int[] kmp_r = new int[s.length()];
        
        String rev = new StringBuilder(s).reverse().toString();
        int j = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(j)){
                kmp_s[i] = kmp_s[i-1] + 1;
                j++;
            }
            else{
                while(j != 0 && s.charAt(i) != s.charAt(j)){
                    j = kmp_s[j-1];
                }
                if(s.charAt(i) == s.charAt(j)){
                    kmp_s[i] = j+1;
                    j++;
                }
            }
        }
        
        j = 0;
        for(int i = 0; i < rev.length(); i++){
            if(rev.charAt(i) == s.charAt(j)){
                kmp_r[i] = i-1 >= 0? kmp_r[i-1]+1:1;
                j++;
            }
            else{
                while(j != 0 && rev.charAt(i) != s.charAt(j)){
                    j = kmp_s[j-1];
                }
                if(rev.charAt(i) == s.charAt(j)){
                    kmp_r[i] = j+1;
                    j++;
                }
            }
        }
        
        // System.out.println(rev.length() - kmp[kmp.length-1]);
        return rev.substring(0, rev.length() - kmp_r[kmp_r.length-1]) + s;
    }
    
    // "aacecaaa"
    // "aaa"
}