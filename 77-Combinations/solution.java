public class Solution {
   List<List<Integer>> ans;
   public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        gen(list, 1, n, k);
        return ans;
    }
    
    
    public void gen(List<Integer> list, int start, int n, int k){
        if(list.size() == k){
            ans.add(new ArrayList<Integer>(list));
        }
        else{
            for(int i = start; i <= n; i++){
                list.add(i);
                gen(list, i+1, n, k);
                list.remove(list.size()-1);
            }
        }
    }
    
    
}