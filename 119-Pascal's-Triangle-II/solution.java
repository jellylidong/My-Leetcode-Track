public class Solution {
    public List<Integer> getRow(int n) {
        List<Integer> list = new ArrayList<>();
        if(n == 0)
            return list;
        list.add(1); 
        for(int i = 1; i <= n; i++){
            for(int j = i; j > 0; j--){
                if(j > list.size())
                    list.add(list.get(j-1));
                else
                    list.set(j, list.get(j) + list.get(j-1));
            }
        }
        
        return list;
    }
}