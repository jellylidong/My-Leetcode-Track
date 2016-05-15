public class Solution {
    public List<Integer> getRow(int n) {
        List<Integer> list = new ArrayList<>();
        if(n < 0)
            return list;
        list.add(1); 
        //start from 0, i means ith level
        //start from 0, j means jth element
        for(int i = 1; i <= n; i++){
            for(int j=i; j > 0; j--){
                if(j == list.size()){
                    //
                    list.add(1);
                }
                else{
                    list.set(j, list.get(j)+list.get(j-1));
                }
            }
        }
        
        return list;
    }
}