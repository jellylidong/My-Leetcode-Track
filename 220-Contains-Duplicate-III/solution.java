public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //make use of bucket
        //if we want to put numbers in a bucket with size s, then it should be put in the bucket num/(size+1)
        //ie for bucket [0, 3), [3, 6) ...
        //for number 2, it shoud be put into 2/(3+1) = 0, ie the 0th bucket
        
        HashMap<Integer, Integer> bkts = new HashMap<>();
        //key is the the bucket number, value is latest number of current bucket
        
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            int bucket = n/(t+1);
            if( bkts.containsKey(bucket) ||
               (bkts.containsKey(bucket-1) && n-bkts.get(bucket-1) <= t) ||
               (bkts.containsKey(bucket+1) && bkts.get(bucket+1)-n <= t))
                return true;
                
            if(bkts.size() == k){
                int tmp = nums[i-k]/(t+1);
                bkts.remove(tmp);
            }
            bkts.put(bucket, n);
        }
        
        return false;
    }
}