public class Solution {
    public String longestCommonPrefix(String[] ss) {
        if(ss.length == 0)
            return "";
        Arrays.sort(ss, new comStr());
        String ans = ss[0];
        for(int i = 1; i < ss.length; i++){
            for(int j = 0; j < ss[i].length() && j < ans.length(); j++){
                if(ans.charAt(j) != ss[i].charAt(j)){
                    ans = ans.substring(0, j);
                    break;
                }
            }
        }
        
        return ans;
    }
    
    public class comStr implements Comparator<String>{
        @Override
        public int compare(String s1, String s2){
            return (s1.length() - s2.length());
        }
    }
}