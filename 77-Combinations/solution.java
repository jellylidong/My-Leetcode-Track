public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return combine(n, k, 1);
    }
    
    public List<List<Integer>> combine(int n, int k, int start) {
        List<List<Integer>> ans = new ArrayList<>();
        if(k == 0 || start > n)
            return ans;
            
        for(int i = start; i <= n; i++){
            for(int j = i+1; j <= n; j++){
                List<List<Integer>> subAns = combine(n, k-1, j);
                for(List<Integer> list: subAns){
                    List<Integer> newList = new ArrayList<>();
                    newList.add(i);
                    newList.addAll(list);
                    ans.add(newList);
                }
            }
        }
        if(ans.size() == 0){
            List<Integer> list = new ArrayList<>();
            list.add(start);
            ans.add(list);
        }
        
        return ans;
    }
}