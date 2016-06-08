public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if(words.length == 0)
            return ans;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++)
            map.put(words[i], i);
            
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j <= words[i].length(); j++){
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                
                if(isP(s1)){
                    String s2rev = new StringBuilder(s2).reverse().toString();
                    if(map.containsKey(s2rev) && map.get(s2rev) != i){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(map.get(s2rev));
                        list.add(i);
                        ans.add(list);
                    }
                }
                
                if(isP(s2) && s2.length() != 0){// we have already processed empty string in isP9(s1), so s2 can not be empty here
                    String s1rev = new StringBuilder(s1).reverse().toString();
                    if(map.containsKey(s1rev)){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(s1rev));
                        ans.add(list);
                    }
                }
            }
        }
        
        return ans;
    }
    
    public boolean isP(String s){
        int lo = 0;
        int hi = s.length()-1;
        while(lo < hi){
            if(s.charAt(lo) != s.charAt(hi))
                return false;
            lo++;
            hi--;
        }
        return true;
    }
}