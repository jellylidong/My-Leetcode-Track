public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> ans = new ArrayList<>();
        if(s.length() == 0){
            ans.add("");
            return ans;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
            if(map.get(c)%2 == 0)
                count--;
            else
                count++;
        }
        if(count > 1)
            return ans;
            
        String mid = "";
        List<Character> list = new ArrayList<>();
        for(Character c: map.keySet()){
            int amount = map.get(c);
            if(amount%2 == 1)
                mid += c;
            for(int i = 0; i < amount/2; i++)
                list.add(c);
        }
        
        genPerm(list, ans, mid, new boolean[list.size()], new StringBuilder());
        
        return ans;
    }
    
    public void genPerm(List<Character> list, List<String> ans, String mid, boolean[] used, StringBuilder sb){
        if(sb.length() == list.size()){
            ans.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }
        
        for(int i = 0; i < list.size(); i++){
            if(used[i])
                continue;
            char c = list.get(i);
            if(i > 0 && list.get(i) == list.get(i-1) && !used[i-1])
                continue;
            sb.append(c);
            used[i] = true;
            genPerm(list, ans, mid, used, sb);
            sb.deleteCharAt(sb.length()-1);
            used[i] = false;
            
        }
    }
}