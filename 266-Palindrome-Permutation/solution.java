public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)-'a']++;
        }
        int oddCount = 0;
        for(int n: count){
            if(n%2 != 0)
                oddCount++;
        }
        
        return oddCount <= 1;
    }
}