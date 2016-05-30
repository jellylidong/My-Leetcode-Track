public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        int len = nums.length;
        
            
        for(int i = 0; i < len; i++){
            pq.offer(nums[i]);
            if(pq.size() > k)
                pq.poll();
                
        }
        // System.out.println(pq.size());
        // System.out.println(pq.size());
        // System.out.println(pq.size());
        // System.out.println(pq.size());
        return pq.peek();
    }
}