public class Solution {
    //"abacb"
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] isIn = new boolean[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)-'a']++;
        }
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(isIn[c-'a']){
                count[c-'a']--;
                continue;
            }
            if(stack.isEmpty()){
                stack.push(c);
                isIn[c-'a'] = true;
            }
            else{
                while(!stack.isEmpty() && c <= stack.peek() && count[stack.peek()-'a'] > 1){
                    count[stack.peek()-'a']--;
                    isIn[stack.peek()-'a'] = false;
                    stack.pop();
                }
                if(!isIn[c-'a']){
                    stack.push(c);
                    isIn[c-'a'] = true;
                }
            }
        }
        String ans = "";
        while(!stack.isEmpty()){
            ans = stack.pop() + ans;
        }
        
        return ans;
    }
}