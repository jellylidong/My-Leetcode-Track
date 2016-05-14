public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        
        int odd = 0;
        for(Character c: map.keySet()){
            if(map.get(c)%2 == 1)
                odd++;
        }
        
        return odd <= 1;
    }
}