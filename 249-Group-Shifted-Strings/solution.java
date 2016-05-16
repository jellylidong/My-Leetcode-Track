public class Solution {
    public List<List<String>> groupStrings(String[] ss) {
        List<List<String>> ans = new ArrayList<>();
        if(ss.length == 0)
            return ans;
       
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String s: ss){
            String diff = "";
            if(s.length() == 1)
                diff = "-1";
            else{
                for(int i = 0; i < s.length()-1; i++){
                    char c1 = s.charAt(i);
                    char c2 = s.charAt(i+1);
                    int tmp = (c1-c2 < 0)? c1-c2+26: c1-c2;
                    diff = diff + tmp;
                }
                    
            }
            int len = s.length();
            String curPair = diff + " " + len;
            if(map.containsKey(curPair)){
                map.get(curPair).add(s);
            }
            else{
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                ans.add(list);
                map.put(curPair, list);
            }
        }
        
        for(List<String> list: ans)
            Collections.sort(list);
        return ans;
        
    }
    
    
}