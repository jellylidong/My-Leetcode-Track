public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int mask = 1;
        for(int i = 1; i <= n; i++){
            int size = list.size();
            for(int j = size-1; j >= 0; j--){
                list.add(list.get(j)^mask);
            }
            mask <<= 1;
        }
        
        return list;
    }
}