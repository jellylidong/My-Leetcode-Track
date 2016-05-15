public class Solution {
    public List<Integer> getRow(int n) {
        List<Integer> list = new ArrayList<>();
        if(n == 0)
            return list;
        list.add(1); 
        for(int i = 2; i <= n; i++){
            for(int j = i; j > 0; j--){
                if(j > list.size())
                    list.add(1);
                else
                    list.set(j-1, list.get(j-1) + list.get(j-2));
            }
        }
        
        return list;
    }
}