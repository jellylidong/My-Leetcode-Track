public class Solution {
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        
        
        
        int len = nums.length;
        if(len == 0)
            return 0;
        long[] sums = new long[len];
        sums[0] = nums[0];
        for(int i = 1; i <len; i++)
            sums[i] = nums[i] + sums[i-1];
            
        return search(sums, 0, len-1, lower, upper);
    }
    
    public int search(long[]sums, int lo, int hi, int lower, int upper){
        if(lo == hi){
            return sums[lo] >= lower && sums[lo] <= upper? 1: 0;
        }
        
        int mid = lo + (hi-lo)/2;
        int count = 0; //count shuold be local variable, not global variable
        count += search(sums, lo, mid, lower, upper) + search(sums, mid+1, hi, lower, upper);
        
        int loId = mid+1; 
        int hiId = mid+1;
        int caId = mid+1;
        
        long[] cache = new long[hi-lo+1];
        for(int i = lo, r = 0; i <= mid; i++, r++){
            while(loId <= hi && sums[loId] - sums[i] < lower) loId++;
            while(hiId <= hi && sums[hiId] - sums[i] <= upper) hiId++;
            
            while(caId <= hi && sums[caId] < sums[i]) cache[r++] = sums[caId++]; 
            cache[r] = sums[i];
            // store all numbers <= sums[i] to cache
            // this works as merge sort
            
            count += hiId - loId;
        }
        
        //copy the sorted part of cache to sums
        //(source array, startId, target array, startId, copy length)
        System.arraycopy(cache, 0, sums, lo, caId-lo); 
        
        return count;
        
    }
}