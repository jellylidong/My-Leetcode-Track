public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //make use of bucket
        //if we want to put numbers in a bucket with size s, then it should be put in the bucket num/(size+1)
        //ie for bucket [0, 3), [3, 6) ...
        //for number 2, it shoud be put into 2/(3+1) = 0, ie the 0th bucket
        
        //!!!!!!!!!!
        //note: this method requires all numbers are >= 0, negative number can not be put into correct bucket
        //for example[-3, 3], k=2, t=4, -3/(4+1) = 0, obviously, not the correct bucket
        
        
        if(k < 1 || t < 0)
            return false;
        
        HashMap<Long, Long> bkts = new HashMap<>();
        //key is the the bucket number, value is latest number of current bucket
        
        for(int i = 0; i < nums.length; i++){
            long n = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = n/((long)t+1);
            if( bkts.containsKey(bucket) ||
               (bkts.containsKey(bucket-1) && n-bkts.get(bucket-1) <= t) ||
               (bkts.containsKey(bucket+1) && bkts.get(bucket+1)-n <= t))
                return true;
                
            if(bkts.size() == k){
                long tmp = ((long)nums[i-k]-Integer.MIN_VALUE)/((long)t+1);
                bkts.remove(tmp);
            }
            bkts.put(bucket, n);
        }
        
        return false;
    }
    
    /*
    [-3,3]
    2
    4
    */
}