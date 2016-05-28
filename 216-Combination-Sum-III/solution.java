public class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        gen(new ArrayList<Integer>(), 1, n, k);
        return ans;
    }
    
    public void gen(List<Integer> cur, int start, int n, int k){
        if(cur.size() == k && n == 0){
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        else{
            for(int i = start; i <= 9; i++){
                cur.add(i);
                gen(cur, i+1, n-i, k);
                cur.remove(cur.size()-1);
            }
        }
    }
}