public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        partition(s, ans, list);
        return ans;
    }
    
    public void partition(String s, List<List<String>> ans, List<String> list){
        if(s.length() == 0){
            ans.add(new ArrayList<String>(list));
            return;
        }
        
        for(int i = 1; i <= s.length(); i++){
            String cur = s.substring(0, i);
            if(isP(cur)){
                list.add(cur);
                partition(s.substring(i), ans, list);
                list.remove(list.size()-1);
            }
        }
    }
    
    public boolean isP(String s){
        if(s.length() == 0)
            return false;
        int lo = 0;
        int hi = s.length()-1;
        char[] cs = s.toCharArray();
        while(lo < hi){
            if(cs[lo] != cs[hi])
                return false;
            lo++;
            hi--;
        }
        return true;
    }
}