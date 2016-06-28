public class Solution {
    public List<List<Integer>> getFactors(int n) {
        return getFactors(n, 2);
    }
    
    public List<List<Integer>> getFactors(int n, int start) {
        List<List<Integer>> ans = new ArrayList<>();
        if(n <= 1)
            return ans;
        for(int i = start; i*i <= n; i++){
            if(n%i == 0){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(n/i);
                ans.add(list);
                List<List<Integer>> subAns = getFactors(n/i, i);
                for(List<Integer> subList: subAns){
                    list = new ArrayList<Integer>();
                    list.add(i);
                    list.addAll(subList);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}