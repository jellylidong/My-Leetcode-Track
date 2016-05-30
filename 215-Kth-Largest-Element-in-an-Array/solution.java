public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int len = nums.length;
        if(k >= len)
            return nums[0];
            
        for(int i = 0; i < len; i++){
            pq.offer(i);
            if(pq.size() == k)
                pq.poll();
                
        }
        
        return pq.peek();
    }
}