public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            int count = map.getOrDefault(n, 0);
            map.put(n, count+1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k)
                pq.poll();
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().getKey());
        }
        
        return ans;
    }
}