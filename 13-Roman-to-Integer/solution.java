public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int pre = map.get(s.charAt(s.length()-1));
        int ans = pre;
        
        for(int i = s.length()-2; i >= 0; i--){
            int cur = map.get(s.charAt(i));
            //if cur >= its right number, plus cur
            //else minus cur
            if(cur >= pre)
                ans += cur;
            else
                ans -= cur;
            pre = cur;
        }
        
        return ans;
    }
}