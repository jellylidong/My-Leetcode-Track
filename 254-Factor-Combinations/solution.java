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
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                newList.add(n/i);
                ans.add(newList);
                List<List<Integer>> subAns = getFactors(n/i, i);
                for(List<Integer> list: subAns){
                    newList = new ArrayList<>();
                    newList.add(i);
                    newList.addAll(list);
                    ans.add(newList);
                }
                
            }
        }
        
        //no need to do this, the line 12 code already solve the case when there's only one number left
        // if(ans.size() == 0 && start != n){
        //     List<Integer> newList = new ArrayList<>();
        //     newList.add(n);
        //     ans.add(newList);
        // }
        
        return ans;
    }
}